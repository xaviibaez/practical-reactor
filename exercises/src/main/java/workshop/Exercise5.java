package workshop;

import java.io.IOException;

public class Exercise5 {

    public void run() throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks

        subscribeUsingSubscribe();

        // Subscribe to a flux using an implementation of BaseSubscriber
        reactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

    public void subscribeUsingSubscribe() {
        reactiveSources.intNumberMono().subscribe(
                x -> System.out.println("Received: " + x),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Done")
        );
        reactiveSources.intNumbersFlux().subscribe(
                x -> System.out.println("Received: " + x),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Done")
        );
    }

    ReactiveSources reactiveSources = new ReactiveSources();
}
