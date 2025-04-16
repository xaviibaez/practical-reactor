package demoApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class MyController {

    @GetMapping("/demo")
    public Mono<String> greetingMessage() {
        /*
         * Why do we use zipWith instead of flatMap?
         *
         * Answer:
         * zipWith is used to combine the results of two asynchronous computations into a single result.
         * It waits for both computations to complete and then combines their results.
         *
         * flatMap is used when you want to transform the result of a computation into another asynchronous computation.
         * In this case, we are not transforming the result, but rather combining two results.
         *
         * So, in this case, zipWith is the appropriate choice.
         *
         */
        return computeMessage().zipWith(computeMessage2()).map(
            value -> value.getT1() + value.getT2()
        );
    }

    private Mono<String> computeMessage() {
        return Mono.just("Hello 1 ").delayElement(Duration.ofSeconds(5));
    }

    private Mono<String> computeMessage2() {
        return Mono.just("Hello 2 ").delayElement(Duration.ofSeconds(5));
    }
}
