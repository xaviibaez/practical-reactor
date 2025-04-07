package workshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * This class is a source of reactive streams used in the exercises.
 * DO NOT MODIFY THIS CODE
 *
 * @author koushikkothagal
 */
public class ReactiveSources {

    public Flux<String> stringNumbersFlux() {
        return Flux.just("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")
                .delayElements(Duration.ofSeconds(1));
    }

    public Flux<Integer> intNumbersFlux() {
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(1));
    }

    public Flux<Integer> intNumbersFluxWithException() {
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .map(e -> {
                    if (e == 5) throw new RuntimeException("An error happened in the flux");
                    return e;
                });
    }

    public Mono<Integer> intNumberMono() {
        return Mono.just(42)
                .delayElement(Duration.ofSeconds(1));
    }

    public Flux<User> userFlux() {
        return Flux.just(
                new User(1, "Lionel", "Messi"),
                new User(2, "Cristiano", "Ronaldo"),
                new User(2, "Diego", "Maradona"),
                new User(4, "Zinedine", "Zidane"),
                new User(5, "Jürgen", "Klinsmann"),
                new User(6, "Gareth", "Bale")
        ).delayElements(Duration.ofSeconds(1));
    }

    public Mono<User> userMono() {
        return Mono.just(
                new User(1, "Lionel", "Messi")
        ).delayElement(Duration.ofSeconds(1));

    }

    public Flux<String> unresponsiveFlux() {
        return Flux.never();
    }

    public Mono<String> unresponsiveMono() {
        return Mono.never();
    }

    public Flux<Integer> intNumbersFluxWithRepeat() {
        return Flux
                .just(1, 2, 1, 1, 3, 2, 4, 5, 1)
                .delayElements(Duration.ofSeconds(1));
    }
}
