package demoApplicationSACAViX;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class PhoneRestClientBlocking {
    //RestTemplate es un cliente HTTP bloqueante
    private RestTemplate restTemplate = new RestTemplate();

    public Mono<List<Phone>> getPhones() {
        return Mono.fromCallable(this::callBlockingService)
                .subscribeOn(Schedulers.boundedElastic()).log();
        //Para que esto? Basicamente bounded elastic es un scheduler que
        // permite ejecutar tareas bloqueantes en un pool de hilos, es decir,
        // no se bloquea el hilo principal (event loop)
    }

    public List<Phone> callBlockingService() {
        ResponseEntity<Phone[]> response = restTemplate
                .getForEntity("https://api.restful-api.dev/objects", Phone[].class);

        SleepUtils.sleep();
        if (Objects.nonNull(response.getBody())) {
            return Arrays.asList(response.getBody());
        }

        throw new RuntimeException("No phones found");
    }


}
