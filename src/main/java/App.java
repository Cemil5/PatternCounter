
import org.reflections.Reflections;
import patterns.Counter;
import patterns.FindPatternStrategy;
import reader.MainReader;
import reader.Reader;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.reflections.scanners.Scanners.SubTypes;

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
        List<String> document = reader.read(args[0]);

        FindPatternStrategy findPattern = FindPatternStrategy.getPattern(args[1]);

        Counter counter = new Counter(findPattern);
        counter.validateDocument(document);

        String result = counter.count(document);

        System.out.println("result :\n" + result);
    }

}
