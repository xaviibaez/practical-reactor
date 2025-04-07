package workshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public void run() throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        // TODO: Write code here
        reactiveSources.intNumbersFluxWithException().subscribe(
                x -> System.out.println("Received: " + x),
                e -> System.out.println("Error: " + e)
        );

        reactiveSources.intNumbersFluxWithException()
                .doOnError(e -> System.out.println("Error: " + e))
                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and continue on errors
        // TODO: Write code here
        reactiveSources.intNumbersFluxWithException()
                .onErrorContinue((e, x) -> System.out.println("Error: " + e))
                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        // TODO: Write code here
        reactiveSources.intNumbersFluxWithException()
                .onErrorResume((e) -> Flux.just(-1, -2))
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

    ReactiveSources reactiveSources = new ReactiveSources();
}
