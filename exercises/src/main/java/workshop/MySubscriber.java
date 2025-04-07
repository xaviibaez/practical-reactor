package workshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

public class MySubscriber<T> extends BaseSubscriber<T> {

    @Override
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed");
        request(2);
    }

    @Override
    public void hookOnNext(T value) {
        System.out.println("Received: " + value);
        request(2);
    }

    @Override
    public void hookOnComplete() {
        System.out.println("Done");
    }

    @Override
    public void hookOnError(Throwable throwable) {
        System.out.println("Error: " + throwable);
    }
}