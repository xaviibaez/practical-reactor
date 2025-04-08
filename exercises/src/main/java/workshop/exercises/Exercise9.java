package workshop.exercises;

import workshop.ReactiveSources;

import java.io.IOException;

public class Exercise9 {


    public void run() throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        // TODO: Write code here
        reactiveSources.intNumbersFlux().count().subscribe();

        // Collect all items of intNumbersFlux into a single list and print it
        // TODO: Write code here
        reactiveSources.intNumbersFlux()
                .collectList()
                .subscribe(list1 -> System.out.println("List: " + list1));

        // Transform to a sequence of sums of adjacent two numbers
        // TODO: Write code here
        reactiveSources.intNumbersFlux()
                .buffer(2)
                .map(list -> list.get(0) + list.get(1))
                .subscribe(System.out::println);


        System.out.println("Press a key to end");
        System.in.read();
    }

    ReactiveSources reactiveSources = new ReactiveSources();
}
