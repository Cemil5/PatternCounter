package patterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FindPatternStrategyTest {

    @Test
    void formatResult() {
        Map<String, Integer> input = Map.of("key1", 5, "key2", 10);
        String expected = "key2, 10\nkey1, 5\n";

        assertEquals(expected, new UniqueWord().formatResult(input));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Should throw an exception with invalid pattern name")
    void getPatternTest() {
        String pattern = "UniqueSentence";
        String expectedMessage = "Please, write one of the valid pattern name as a second command line argument: UniquePhrase, UniqueWord, UniqueNumber";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> FindPatternStrategy.getPattern(pattern));
        assertEquals(expectedMessage, exception.getMessage());
    }
}