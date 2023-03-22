import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Should not throw any exception with valid args")
    void validArgTest() {
        String[] args = {"input.txt", "UniqueWord"};
        assertDoesNotThrow( ()-> App.main(args));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Should throw an exception with invalid args")
    void invalidArgsTest() {
        String[] args = {""};
        String expectedMessage = "Usage: java  <filename>, <PatternName> >> \n" +
                "Usage: java -cp . App.java input.txt UniqueNumber";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> App.main(args),
                "Usage: java  <filename>, <PatternName> >> \nUsage: java -cp . App.java input.txt UniqueNumber");
        assertEquals(expectedMessage, exception.getMessage());
    }

}