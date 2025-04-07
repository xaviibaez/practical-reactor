package workshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StreamSourcesTest {

    @Test
    void it_should_return_element_from_string_numbers_stream() {
        assertEquals(streamSources.stringNumbersStream().count(), 10);
    }

    @Test
    void it_should_return_element_from_int_numbers_stream() {
        assertEquals(streamSources.intNumbersStream().count(), 10);
    }

    @Test
    void it_should_return_element_from_int_numbers_stream_with_exception() {
        assertEquals(streamSources.intNoNumbersStream().count(), 1);
    }

    @Test
    void it_should_return_element_from_user_stream() {
        assertEquals(streamSources.userStream().count(), 6);
    }

    StreamSources streamSources = new StreamSources();
}