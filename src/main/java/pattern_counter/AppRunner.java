package pattern_counter;

import pattern_counter.reader.MainReader;
import pattern_counter.reader.Reader;

public class AppRunner {

    public static void main(String[] args) {
        Reader reader = new MainReader();
        System.out.println(reader.read(args));
    }

}
