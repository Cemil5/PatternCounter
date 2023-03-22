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
        assertThrows(IllegalArgumentException.class, () -> App.main(args),
                "Usage: java  <filename>, <PatternName> >> \nUsage: java -cp . App.java input.txt UniqueNumber");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Should throw an exception with invalid fila path")
    void invalidFilePath() {
        String[] args = {"invalid.txt", "UniqueWord"};
        assertThrows(RuntimeException.class, () -> App.main(args),
                "Usage: java  <filename>, <PatternName> >> \nUsage: java -cp . App.java input.txt UniqueNumber");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Document should contain at least 3 words")
    void documentLessThan3Word() {
        String[] args = {"minidoc.txt", "UniqueWord"};
        assertThrows(IllegalArgumentException.class, () -> App.main(args),
                "Document should contain at least 3 words");
    }

}