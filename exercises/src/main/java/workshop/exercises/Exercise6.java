package workshop.exercises;

import workshop.ReactiveSources;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Exercise6 {


    public void run() throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds
        // TODO: Write code here
        String resultMono = reactiveSources.unresponsiveMono()
                .block(Duration.ofSeconds(5));

        System.out.println("Result: " + resultMono);

        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        // TODO: Write code here
        List<String> resultFlux = reactiveSources.unresponsiveFlux()
                .collectList()
                .block(Duration.ofSeconds(5));

        System.out.println("Result: " + resultFlux);
        System.out.println("Press a key to end");
        System.in.read();
    }

    ReactiveSources reactiveSources = new ReactiveSources();
}
