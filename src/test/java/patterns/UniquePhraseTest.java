package patterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniquePhraseTest {

    @Test
    @DisplayName("Counts occurrences of each unique number for given list")
    void countUniquePhrases() {
        List<String> input = List.of("1000 a big surprise 2000 hello is a big surprise 1000");
        String expected = "1000 a big, 1\n" +
                "a big surprise, 2\n" +
                "big surprise 2000, 1\n" +
                "surprise 2000 hello, 1\n" +
                "2000 hello is, 1\n" +
                "hello is a, 1\n" +
                "is a big, 1\n" +
                "big surprise 1000, 1\n";
        assertEquals(expected, new UniquePhrase().findPattern(input));
    }

}