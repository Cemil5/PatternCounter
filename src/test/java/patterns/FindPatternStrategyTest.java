package patterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FindPatternStrategyTest {

    @Test
    @DisplayName("Should display result with valid format")
    void formatResult() {
        Map<String, Integer> input = new LinkedHashMap<>();
        input.put("key1", 5);
        input.put("key2", 10);
        String expected = "key1, 5\n" +
                          "key2, 10\n";

        assertEquals(expected, new UniqueWord().formatResult(input));
    }

    @Test
    @DisplayName("Should throw an exception with invalid pattern name")
    void getPatternTest() {
        String pattern = "UniqueSentence";
        String expectedMessage = "Please, write one of the valid pattern name as a second command line argument: UniquePhrase, UniqueWord, UniqueNumber";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> FindPatternStrategy.getPattern(pattern));
        assertEquals(expectedMessage, exception.getMessage());
    }
}