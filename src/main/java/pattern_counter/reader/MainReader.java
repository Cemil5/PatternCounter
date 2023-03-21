package pattern_counter.reader;

import pattern_counter.patterns.FindPattern;
import pattern_counter.patterns.MainFinder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class MainReader implements Reader {

    @Override
    public String read(String[] input) {
        String[] result = new String[2];
        StringBuilder builder = new StringBuilder();
        FindPattern findPattern = new MainFinder();
        Scanner scanner;
        try {
            scanner = new Scanner(new FileReader(input[0]));
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine());
            }
            result[0] = builder.toString();
            result[1] = input[1];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(result));
        return findPattern.findPattern(result);
    }

}
