package io.ordi.rx;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TempObservableMain {

    public static void main(String[] args) {
//        Observable<TempInfo> observable = getTempObservable("서울");
//        Observable<TempInfo> observable = getCelsiusTempObservable("서울");
        Observable<TempInfo> observable = getCelsiusTempsObservable("서울", "성남", "위례");
        observable.blockingSubscribe(new TempObserver());
    }

    public static Observable<TempInfo> getTempObservable(String town) {
        return Observable.create(emitter -> {
            Observable.interval(1, TimeUnit.SECONDS) // 초마다 1씩 증가하는 long을 방출하는 Observable
                    .subscribe(i -> {
                       if (!emitter.isDisposed()) { // 소비된 Observer 폐기하지 않으면 어떤 작업 수행
                           if (i >= 5) {
                               emitter.onComplete();
                           } else {
                               try {
                                   emitter.onNext(TempInfo.fetch(town));
                               } catch (Exception e) {
                                   emitter.onError(e);
                               }
                           }
                       }
                    });
        });
    }

    public static Observable<TempInfo> getCelsiusTempObservable(String town) {
        return getTempObservable(town)
                .map(temp -> new TempInfo(temp.getTown(),
                        (temp.getTemp() - 32) * 5 / 9));
    }

    public static Observable<TempInfo> getCelsiusTempsObservable(String... towns) {
        return Observable.merge(Arrays.stream(towns)
                .map(TempObservableMain::getCelsiusTempObservable)
                .collect(Collectors.toList()));
    }
}
