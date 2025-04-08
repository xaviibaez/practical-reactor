package workshop.exercises;

import workshop.StreamSources;

import java.util.concurrent.CompletableFuture;

public class Exercise1 {

    public void run() {
        //Return a computation result using completable future, see, it is blocking!
        completableFuture();
        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        printNumbersStream();

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        printNumbersLessThan5Stream();

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        printSecondAndThridNumbersGreaterThan5Stream();

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        printFirstNumberGreaterThan5Stream();
        printFirstNumberGreaterThan5StreamWithElse();

        // Print first names of all users in userStream
        // TODO: Write code here
        printAllUsersNames();

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        printAllUsersNamesThatHaveIds();
    }

    public void completableFuture() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 1 + 1;
        });
        System.out.println(future.join());
    }

    public void printNumbersStream() {
        streamSources.intNumbersStream().forEach(System.out::println);
    }

    public void printNumbersLessThan5Stream() {
        streamSources.intNumbersStream()
                .filter(x -> x < 5)
                .forEach(System.out::println);
    }

    public void printSecondAndThridNumbersGreaterThan5Stream() {
        streamSources.intNumbersStream()
                .filter(x -> x > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);
    }

    public void printFirstNumberGreaterThan5Stream() {
        streamSources.intNumbersStream()
                .filter(x -> x > 5)
                .limit(1)
                .forEach(System.out::println);
    }

    public void printFirstNumberGreaterThan5StreamWithElse() {
        int result = streamSources.intNoNumbersStream()
                .filter(x -> x > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(result);
    }

    public void printAllUsersNames() {
        streamSources.userStream()
                .forEach(x -> System.out.println(x.getFirstName()));
    }

    public void printAllUsersNamesThatHaveIds() {
        //Option 1:
        streamSources.userStream()
                .filter(x ->
                        streamSources.intNumbersStream()
                                .toList()
                                .contains(x.getId())
                )
                .forEach(x -> System.out.println(x.getFirstName()));

        //Option 2:
        /*
        streamSources.intNumbersStream()
                .parallel()
                .flatMap((id -> StreamSources.userStream().filter(user -> user.getId() == id)))
                .map(User::getFirstName)
                .forEach(System.out::println);
        */
    }

    StreamSources streamSources = new StreamSources();
}
