package workshop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Exercise4Test {

    @Test
    void it_should_print_the_value_from_intNumberMono_when_it_emits() throws InterruptedException {
        ByteArrayOutputStream outContent = getByteArrayOutputStream();

        exercise4.printIntNumberMono();

        Thread.sleep(1100);

        assertEquals("42\n", outContent.toString());
    }

    @Test
    void it_should_get_the_value_from_the_Mono_into_an_integer_variable() throws InterruptedException {
        var result = exercise4.getValueFromMono();

        Thread.sleep(1100);

        assertEquals("42", result.get(0).toString());
    }

    private ByteArrayOutputStream getByteArrayOutputStream() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        return outContent;
    }

    Exercise4 exercise4 = new Exercise4();

    @BeforeEach
    void setUp() {
        System.setOut(System.out);
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }
}