package patterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniqueNumberTest {

    @Test
    @DisplayName("Counts occurrences of each unique number for given list")
    void countUniqueNumbers() {
        List<String> input = List.of("1000 a big surprise 2000 hello is a big surprise 1000");
        String expected = "1000, 2\n2000, 1\n";
        assertEquals(expected, new UniqueNumber().findPattern(input));
    }

}