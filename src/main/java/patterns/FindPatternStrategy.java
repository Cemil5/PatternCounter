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

    static FindPatternStrategy getPattern(String pattern){
        FindPatternStrategy findPattern;
        try {
            Class<FindPatternStrategy> findPatternStrategy = (Class<FindPatternStrategy>) Class.forName("patterns." + pattern);
            findPattern = findPatternStrategy.getDeclaredConstructor().newInstance();
        } catch (Exception e){
            throw new IllegalArgumentException("Please, write a valid pattern name");
            //        Reflections reflections = new Reflections("com.my.project");
//
//        Set<Class<?>> subTypes =
//                reflections.get(SubTypes.of(SomeType.class).asClass());

//        Reflections reflections = new Reflections("main.patterns");
//
//        Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);
//        System.out.println(allClasses);
        }
        return findPattern;
    }
}
