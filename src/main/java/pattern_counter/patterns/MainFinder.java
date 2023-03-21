package pattern_counter.patterns;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class MainFinder implements FindPattern {

    @Override
    public String findPattern(String[] input) {
        return getPattern(input);
    }

    private String getPattern(String[] input) {
        String result = "";
        switch (input[1]) {
            case "1":
                result = countUniqueWords(input[0]);
                break;
            case "2":
                result = countUniqueNumbers(input[0]);
                break;
            case "3":
                result = countConsecutiveWords(input[0]);
                break;
            default:
                throw new NoSuchElementException("There is no pattern based on the second command line argument." +
                        "Please write a number between 1 and 3");
        }
        return result;
    }

    private String countUniqueWords(String input) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = input.replaceAll("\\d+", "").split("\\s+");
        for (String word : words) {
            if (!word.equals("")){
                map.put(word, map.getOrDefault(word, 0)+1);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> each : map.entrySet()) {
            builder.append(each.getKey()).append(", ").append(each.getValue()).append("\n");
        }
        return builder.toString();
    }

    private String countUniqueNumbers(String input) {
        return null;
    }

    private String countConsecutiveWords(String input) {
        return null;
    }

}
