package workshop;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class ReactiveSourcesTest {

    @Test
    void it_should_return_element_from_string_number_flux() {
        StepVerifier.create(reactiveSources.stringNumbersFlux())
                .expectNext("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")
                .verifyComplete();
    }

    @Test
    void it_should_return_element_from_int_number_flux() {
        StepVerifier.create(reactiveSources.intNumbersFlux())
                .expectNext(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .verifyComplete();
    }

    @Test
    void it_should_return_element_from_int_number_flux_with_exception() {
        StepVerifier.create(reactiveSources.intNumbersFluxWithException())
                .expectNext(1, 2, 3, 4)
                .expectErrorMessage("An error happened in the flux")
                .verify();
    }

    @Test
    void it_should_return_element_from_int_number_mono() {
        StepVerifier.create(reactiveSources.intNumberMono())
                .expectNext(42)
                .verifyComplete();
    }

    @Test
    void it_should_return_element_from_user_flux() {
        StepVerifier.create(reactiveSources.userFlux())
                .expectNextCount(6)
                .verifyComplete();
    }

    @Test
    void it_should_return_element_from_user_mono() {
        StepVerifier.create(reactiveSources.userMono())
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void it_should_return_element_from_unresponsive_flux() {
        StepVerifier.create(reactiveSources.unresponsiveFlux())
                .expectSubscription()
                .thenCancel()
                .verify();
    }

    @Test
    void it_should_return_element_from_unresponsive_mono() {
        StepVerifier.create(reactiveSources.unresponsiveMono())
                .expectSubscription()
                .thenCancel()
                .verify();
    }

    @Test
    void it_should_return_element_from_int_number_flux_with_repeat() {
        StepVerifier.create(reactiveSources.intNumbersFluxWithRepeat())
                .expectNext(1, 2, 1, 1, 3, 2, 4, 5, 1)
                .verifyComplete();
    }

    ReactiveSources reactiveSources = new ReactiveSources();
}