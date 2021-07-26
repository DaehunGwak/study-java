package io.ordi.flow;

import lombok.AllArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.*;

@AllArgsConstructor
public class TempSubscription implements Subscription {

    private final Subscriber<? super TempInfo> subscriber;
    private final String town;

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    public void request(long n) {
        // Subscriber 가 만든 요청 반복
        executor.submit(() -> {
            for (long i = 0L; i < n; i++) {
                try {
                    subscriber.onNext(TempInfo.fetch(town));
                } catch (Exception e) {
                    subscriber.onError(e);
                    executor.shutdown();
                    break;
                }
            }
        });
    }

    @Override
    public void cancel() {
        // 구독 취소 시, subscriber 에게 완료 시그널
        subscriber.onComplete();
    }
}
