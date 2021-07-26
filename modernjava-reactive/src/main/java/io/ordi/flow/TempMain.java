package io.ordi.flow;

import java.util.concurrent.Flow;

public class TempMain {

    public static void main(String[] args) {
        getTempPublisher("분당").subscribe(new TempSubscriber());
    }

    private static Flow.Publisher<TempInfo> getTempPublisher(String town) {
        return subscriber -> subscriber.onSubscribe(
                new TempSubscription(subscriber, town));
    }
}
