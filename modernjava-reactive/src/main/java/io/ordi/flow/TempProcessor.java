package io.ordi.flow;

import java.util.concurrent.Flow.*;

/**
 * Processor의 목적: Publisher를 구독한 다음 수신한 데이터를 가공해 다시 제공하는 것
 * 화씨를 섭씨로 변환
 * TempInfo -> TempInfo
 */
public class TempProcessor implements Processor<TempInfo, TempInfo> {

    private Subscriber<? super TempInfo> subscriber;

    @Override
    public void subscribe(Subscriber<? super TempInfo> subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscriber.onSubscribe(subscription);
    }

    @Override
    public void onNext(TempInfo item) {
        subscriber.onNext(new TempInfo(item.getTown(),
                (item.getTemp() - 32) * 5 / 9));
    }

    @Override
    public void onError(Throwable throwable) {
        subscriber.onError(throwable);
    }

    @Override
    public void onComplete() {
        subscriber.onComplete();
    }
}
