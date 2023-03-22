package patterns;


import java.util.List;

public class Counter {

    private final FindPatternStrategy findPatternStrategy;

    public Counter(FindPatternStrategy findPatternStrategy) {
        this.findPatternStrategy = findPatternStrategy;
    }

    /**
     * This is strategy design pattern implementation
     * @param document
     * @return
     */
    public String count(List<String> document){
        return findPatternStrategy.findPattern(document);
    }

    public void validateDocument(List<String> document){
        if (document.toString().trim().replaceAll("\\[|\\]","").split("\\s+").length < 3){
            throw new IllegalArgumentException("Document should contain at least 3 words");
        }
    }
}


