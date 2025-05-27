package demoApplicationSACAViX;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;

@Component
public class PhoneRestClientReactive {
    private final WebClient webClient;

    public PhoneRestClientReactive() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.restful-api.dev/objects")
                .build();
    }

    public Mono<List<Phone>> getPhones() {
        SleepUtils.sleep();
        return webClient.get()
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Phone>>() {
                })
                .doOnNext(list -> list.sort(Comparator.comparing(Phone::getName)))
                .log();
    }
}
