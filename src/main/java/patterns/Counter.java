package patterns;


import java.util.List;

public class Counter {

    private final FindPatternStrategy findPatternStrategy;

    public Counter(List<String> list, FindPatternStrategy findPatternStrategy) {
        this.findPatternStrategy = findPatternStrategy;
    }

    /**
     * This is strategy design pattern implementation
     * @param list
     * @return
     */
    public String count(List<String> list){
        return findPatternStrategy.findPattern(list);
    }
}


