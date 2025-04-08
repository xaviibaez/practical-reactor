package workshop.exercises;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise3Test {

    @Test
    void it_should_get_all_numbers_in_the_ReactiveSources_intNumbersFlux_stream_into_a_List_and_print_the_list_and_its_size() throws InterruptedException {
        ByteArrayOutputStream outContent = getByteArrayOutputStream();

        exercise3.getAllNumbers();

        Thread.sleep(11000);

        assertEquals("List: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]\nSize: 10\n", outContent.toString());
    }

    private ByteArrayOutputStream getByteArrayOutputStream() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        return outContent;
    }

    Exercise3 exercise3 = new Exercise3();

    @BeforeEach
    void setUp() {
        System.setOut(System.out);
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }
}