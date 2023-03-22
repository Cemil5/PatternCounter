
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
 - application informs the user about the process.
 - if there is an unexpected input, application should provide user-friendly messages on the console.
 - build tool usage is not restricted.
 */
public class App {
    public static void main(String[] args) {

        if (args.length != 2) {
            throw new IllegalArgumentException("Usage: java -jar PatternCounter-1.0.jar <filename>, <PatternName> >> \n" +
                    "Example  : java -jar PatternCounter-1.0.jar input.txt UniqueNumber");
        }

        System.out.println("Application started reading arguments");
        System.out.println("File Path = " + args[0]);
        System.out.println("Pattern = " + args[1]);

        List<String> document;
        Counter counter;
        try {
            Reader reader = new MainReader();
            document = reader.read(args[0]);

            FindPatternStrategy findPattern = FindPatternStrategy.getPattern(args[1]);

            counter = new Counter(findPattern);
            counter.validateDocument(document);
        } catch (Exception e){
            System.err.println(e.getMessage());
            return;
        }
        String result = counter.count(document);
        System.out.println("result :\n" + result);
    }

}
