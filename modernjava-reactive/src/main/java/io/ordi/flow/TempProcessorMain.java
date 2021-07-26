package io.ordi.flow;

import java.util.concurrent.Flow;

public class TempProcessorMain {

    public static void main(String[] args) {
        getCelsiusTempPublisher("성남").subscribe(new TempSubscriber());
    }

    public static Flow.Publisher<TempInfo> getCelsiusTempPublisher(String town) {
        return subscriber -> {
            TempProcessor processor = new TempProcessor();
            processor.subscribe(subscriber);
            processor.onSubscribe(new TempSubscription(processor, town));
        };
    }
}
