package workshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        reactiveSources.intNumberMono().subscribe(System.out::println);
    }

    public List<Integer> getValueFromMono() {
        List<Integer> l = new ArrayList<>();
        reactiveSources.intNumberMono().map(l::add).subscribe();
        return l;
    }

    ReactiveSources reactiveSources = new ReactiveSources();
}
