package workshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static workshop.ReactiveSources.intNumberMono;

public class Exercise4 {

    public void run() throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here
        printIntNumberMono();

        // Get the value from the Mono into an integer variable
        // TODO: Write code here
        getValueFromMono();

        System.out.println("Press a key to end");
        System.in.read();
    }

    public void printIntNumberMono() {
        intNumberMono().subscribe(System.out::println);
    }

    public List<Integer> getValueFromMono() {
        List<Integer> l = new ArrayList<>();
        intNumberMono().map(l::add).subscribe();
        return l;
    }
}
