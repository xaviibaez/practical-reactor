package workshop.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise1Test {

    @Test
    void it_should_print_10_numbers_stream() {
        ByteArrayOutputStream outContent = getByteArrayOutputStream();

        exercise1.printNumbersStream();

        String expectedOutput = "0\n2\n4\n6\n8\n10\n12\n14\n16\n18\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void it_should_print_number_less_than_5() {
        ByteArrayOutputStream outContent = getByteArrayOutputStream();

        exercise1.printNumbersLessThan5Stream();

        String expectedOutput = "0\n2\n4\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void it_should_print_second_and_third_number_greater_than_5() {
        ByteArrayOutputStream outContent = getByteArrayOutputStream();

        exercise1.printSecondAndThridNumbersGreaterThan5Stream();

        String expectedOutput = "8\n10\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void it_should_print_first_number_greater_than_5() {
        ByteArrayOutputStream outContent = getByteArrayOutputStream();

        exercise1.printFirstNumberGreaterThan5Stream();

        String expectedOutput = "6\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void it_should_print_less_than_1_if_has_no_data() {
        ByteArrayOutputStream outContent = getByteArrayOutputStream();

        exercise1.printFirstNumberGreaterThan5StreamWithElse();

        String expectedOutput = "-1\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void it_should_print_names_of_all_users() {
        ByteArrayOutputStream outContent = getByteArrayOutputStream();

        exercise1.printAllUsersNames();
        String expectedOutput =
                "Lionel\n" +
                        "Cristiano\n" +
                        "Diego\n" +
                        "Zinedine\n" +
                        "Jürgen\n" +
                        "Gareth\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void it_should_print_names_of_all_users_that_has_ids_from_numbers_streams() {
        ByteArrayOutputStream outContent = getByteArrayOutputStream();

        exercise1.printAllUsersNamesThatHaveIds();
        String expectedOutput =
                "Cristiano\n" + "Diego\n" + "Zinedine\n" + "Gareth\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    private ByteArrayOutputStream getByteArrayOutputStream() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        return outContent;
    }

    @BeforeEach
    void setUp() {
        System.setOut(System.out);
    }

    Exercise1 exercise1 = new Exercise1();
}