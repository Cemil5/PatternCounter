package patterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniqueWordTest {

    @Test
    @DisplayName("Counts occurrences of each unique number for given list")
    void countUniqueWords() {
        List<String> input = List.of("1000 a big surprise 2000 hello is a big surprise 1000");
        String expected = "a, 2\n" +
                "big, 2\n" +
                "surprise, 2\n" +
                "hello, 1\n" +
                "is, 1\n";
        assertEquals(expected, new UniqueWord().findPattern(input));
    }

}