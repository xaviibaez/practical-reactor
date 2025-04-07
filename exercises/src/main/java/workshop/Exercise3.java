package workshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exercise3 {

    public void run() throws IOException {
        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here

        getAllNumbers();

        System.out.println("Press a key to end");
        System.in.read();
    }

    public void getAllNumbers() {
        //Option 1:
        //List<Integer> l = new ArrayList<>();
        //intNumbersFlux().doOnNext(l::add).subscribe();
        //System.out.println("List: " + l);
        //System.out.println("Size: " + l.size());

        //Option 2:
        //intNumbersFlux()
        //        .collectList()
        //        .subscribe(numbersList -> {
        //            System.out.println("List: " + numbersList);
        //            System.out.println("Size: " + numbersList.size());
        //        });

        //Option 3 blocking:
        List<Integer> numbers = reactiveSources.intNumbersFlux().toStream().toList();
        System.out.println("List: " + numbers);
        System.out.println("Size: " + numbers.size());
    }

    ReactiveSources reactiveSources = new ReactiveSources();
}
