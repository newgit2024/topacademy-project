package functional.streams;

import java.util.Comparator;
import java.util.stream.Stream;

public class App2 {
    public static void main(String[] args) {
        Stream.of("hello", "what's up", "how are you", "bye")
                .filter(l -> l.indexOf(' ') != -1)
                .map(l -> l.replaceAll(" ", "_"))
                .sorted(Comparator.comparingInt(String::length))
                .peek(System.out::println)
                .forEach(System.out::println);
        //hello
        //what's up
        //how are you
        //bye
        //what's_up
        //how_are_you
    }
}
