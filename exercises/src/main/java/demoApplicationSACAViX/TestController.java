package demoApplicationSACAViX;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class TestController {
    private final PhoneRestClientBlocking phoneRestClientBlocking;
    private final PhoneRestClientReactive phoneRestClientReactive;

    public TestController(PhoneRestClientBlocking phoneRestClientBlocking, PhoneRestClientReactive phoneRestClientReactive) {
        this.phoneRestClientBlocking = phoneRestClientBlocking;
        this.phoneRestClientReactive = phoneRestClientReactive;
    }

    @GetMapping("/phones-reactive")
    public Mono<List<Phone>> getPhonesReactive() {
        return phoneRestClientReactive.getPhones();
    }

    @GetMapping("/phones-blocking")
    public Mono<List<Phone>> getPhonesBlocking() {
        return phoneRestClientBlocking.getPhones();
    }
}
