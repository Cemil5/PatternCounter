package patterns;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface FindPatternStrategy {

    String findPattern(List<String> input);

    default String formatResult(Map<?, Integer> map){
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<?, Integer> each : map.entrySet()) {
            builder.append(each.getKey()).append(", ").append(each.getValue()).append("\n");
        }
        return builder.toString();
    }

}
