package workshop.exercises;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Exercise5Test {

    @Test
    void it_should_subscribe_to_a_flux_using_the_error_and_completion_hooks_mono() throws InterruptedException {
        ByteArrayOutputStream outContent = getByteArrayOutputStream();

        exercise5.subscribeUsingSubscribeMono();

        Thread.sleep(1100);

        assertEquals("Received: 42\nDone\n", outContent.toString());
    }

    @Test
    void it_should_subscribe_to_a_flux_using_the_error_and_completion_hooks_flux() throws InterruptedException {
        ByteArrayOutputStream outContent = getByteArrayOutputStream();

        exercise5.subscribeUsingSubscribeFlux();

        Thread.sleep(1100);

        assertEquals("Received: 1\n", outContent.toString());
    }

    @Test
    void it_should_subscribe_using_a_base_subscriber_implementation() throws InterruptedException {
        ByteArrayOutputStream outContent = getByteArrayOutputStream();

        exercise5.subscribeUsingABaseSubscriberImplementation();

        Thread.sleep(1100);

        assertEquals("Subscribed\nReceived: 1\n", outContent.toString());
    }

    private ByteArrayOutputStream getByteArrayOutputStream() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        return outContent;
    }

    Exercise5 exercise5 = new Exercise5();

    @BeforeEach
    void setUp() {
        System.setOut(System.out);
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }
}