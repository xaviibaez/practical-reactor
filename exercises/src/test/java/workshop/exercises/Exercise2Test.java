package workshop.exercises;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise2Test {

    @Test
    void it_should_print_all_numbers_in_reactive_sources_intNumbersFlux_stream() throws InterruptedException {
        ByteArrayOutputStream outContent = getByteArrayOutputStream();

        exercise2.printNumberFlux();

        Thread.sleep(11000);

        assertEquals("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n", outContent.toString());
    }

    @Test
    void it_should_print_all_users_in_reactive_sources_userFlux_stream() throws InterruptedException {
        ByteArrayOutputStream outContent = getByteArrayOutputStream();

        exercise2.printUserFlux();

        Thread.sleep(7000);

        assertEquals("Name: Lionel Messi ID: 1\nName: Cristiano Ronaldo ID: 2\nName: Diego Maradona ID: 2\nName: Zinedine Zidane ID: 4\nName: Jürgen Klinsmann ID: 5\nName: Gareth Bale ID: 6\n", outContent.toString());
    }

    private ByteArrayOutputStream getByteArrayOutputStream() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        return outContent;
    }

    Exercise2 exercise2 = new Exercise2();

    @BeforeEach
    void setUp() {
        System.setOut(System.out);
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

}