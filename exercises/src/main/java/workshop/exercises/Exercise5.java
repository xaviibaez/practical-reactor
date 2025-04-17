package workshop.exercises;

import workshop.MySubscriber;
import workshop.ReactiveSources;

import java.io.IOException;

public class Exercise5 {

    public void run() throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks

        subscribeUsingSubscribeMono();
        subscribeUsingSubscribeFlux();

        // Subscribe to a flux using an implementation of BaseSubscriber
        subscribeUsingABaseSubscriberImplementation();

        System.out.println("Press a key to end");
        System.in.read();
    }


    public void subscribeUsingSubscribeMono() {
        reactiveSources.intNumberMono().subscribe(
                x -> System.out.println("Received: " + x),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Done")
        );
    }

    public void subscribeUsingSubscribeFlux() {
        reactiveSources.intNumbersFlux().subscribe(
                x -> System.out.println("Received: " + x),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Done")
        );
    }

    public void subscribeUsingABaseSubscriberImplementation() {
        reactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());
    }

    ReactiveSources reactiveSources = new ReactiveSources();
}
