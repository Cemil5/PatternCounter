
import patterns.Counter;
import patterns.FindPatternStrategy;
import reader.MainReader;
import reader.Reader;

import java.util.List;

/*
I assumed that :
 - second command line argument can be the name of the pattern which also equals the ClassName of this pattern.
 - order of result should take into account insertion order.
 - input text can only contain integer as numbers.
 */
public class App {
    public static void main(String[] args) {

        if (args.length != 2) {
            throw new IllegalArgumentException("Usage: java  <filename>, <PatternName> >> \n" +
                    "Usage: java -cp . App.java input.txt UniqueNumber");
        }

        System.out.println("Application started reading arguments");
        System.out.println("File Path = " + args[0]);
        System.out.println("Pattern = " + args[1]);

        Reader reader = new MainReader();
        List<String> read = reader.read(args[0]);

        if (read.get(0).split("\\s+").length < 3){
            throw new IllegalArgumentException("Document should contain at least 3 words");
        }
        FindPatternStrategy f;
        try {
            Class<FindPatternStrategy> findPatternStrategy = (Class<FindPatternStrategy>) Class.forName("patterns." + args[1]);
            f = findPatternStrategy.getDeclaredConstructor().newInstance();
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


        Counter counter = new Counter(read, f);

        String result = counter.count(read);

        System.out.println("result :\n" + result);


    }

//    public Set<Class> findAllClassesUsingGoogleGuice(String packageName) throws IOException {
//        return ClassPath.from(ClassLoader.getSystemClassLoader())
//                .getAllClasses()
//                .stream()
//                .filter(clazz -> clazz.getPackageName()
//                        .equalsIgnoreCase(packageName))
//                .map(clazz -> clazz.load())
//                .collect(Collectors.toSet());
//    }
}
