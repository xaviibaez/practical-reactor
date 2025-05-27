package demoApplicationSACAViX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringwebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringwebfluxApplication.class, args);
        System.out.println("Total processors: " + Runtime.getRuntime().availableProcessors());
        //Numero dedicado de eventLoops que se crean en un proyecto reactivo
        // es equivalente al numero de procesadores que hay
    }
}
