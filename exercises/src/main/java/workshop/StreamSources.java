package workshop;

import java.util.stream.Stream;

/**
 * This class is a source of collection streams used in the exercises.
 * DO NOT MODIFY THIS CODE
 *
 * @author koushikkothagal
 */
public class StreamSources {

    public Stream<String> stringNumbersStream() {
        return Stream.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
    }

    public Stream<Integer> intNumbersStream() {
        return Stream.iterate(0, i -> i + 2)
                .limit(10);
    }

    public Stream<Integer> intNoNumbersStream() {
        return Stream.of(0);
    }

    public Stream<User> userStream() {
        return Stream.of(
                new User(1, "Lionel", "Messi"),
                new User(2, "Cristiano", "Ronaldo"),
                new User(2, "Diego", "Maradona"),
                new User(4, "Zinedine", "Zidane"),
                new User(5, "Jürgen", "Klinsmann"),
                new User(6, "Gareth", "Bale")
        );
    }
}
