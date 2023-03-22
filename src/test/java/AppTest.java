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

    @org.junit.jupiter.api.Test
    @DisplayName("Should throw an exception with invalid file path")
    void invalidFilePath() {
        String[] args = {"invalid.txt", "UniqueWord"};
        Exception exception = assertThrows(RuntimeException.class, () -> App.main(args));
        assertEquals("Check if file path is exist", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Should throw an exception with invalid pattern name")
    void invalidPatternName() {
        String[] args = {"input.txt", "UniqueSentence"};
        String expectedMessage = "Please, write one of the valid pattern name as a second command line argument: UniquePhrase, UniqueWord, UniqueNumber";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> App.main(args));
        assertEquals(expectedMessage, exception.getMessage());
    }

}