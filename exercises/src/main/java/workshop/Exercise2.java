package workshop;

import java.io.IOException;

import static workshop.ReactiveSources.intNumbersFlux;
import static workshop.ReactiveSources.userFlux;

public class Exercise2 {

    public void run() throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // TODO: Write code here
        printNumberFlux();

        // Print all users in the ReactiveSources.userFlux stream
        // TODO: Write code here
        printUserFlux();

        System.out.println("Press a key to end");
        System.in.read();
    }

    public void printUserFlux() {
        userFlux().subscribe(x -> System.out.println("Name: " + x.getFirstName() + " " + x.getLastName() + " ID: " + x.getId()));
    }

    public void printNumberFlux() {
        intNumbersFlux().subscribe(System.out::println);
    }

}
