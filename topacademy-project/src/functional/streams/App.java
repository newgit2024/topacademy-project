package functional.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("hello", "what's up", "how are you", "bye");
        Stream<String> filteredStream = stringStream.filter(l -> l.indexOf(' ') != -1);
        Stream<String> processedStream = filteredStream.map(l -> l.replaceAll(" ", "_"));
        Stream<String> sorted = processedStream.sorted(Comparator.comparingInt(String::length));
        sorted.forEach(System.out::println);




















        // Stream.of(...)....
        // list.stream().....
        /*
        var integerList = IntStream.range(0, 1000)
                .boxed()
                .peek(System.out::println)
                .collect(Collectors.toList());

         */

        //String s = "Hello";
        //s.chars()....

        /*
        List<String> strings = List.of("hello", "what's up", "how are you", "bye");

        strings.stream()
                .map(String::length)
                .forEach(System.out::println);

        var newList = strings.stream()
                .filter(s -> s.contains("a"))
                .collect(Collectors.toList());

         */





        /*
        stringStream
                .peek(System.out::println)
                .map(StringBuilder::new)
                .forEach(System.out::println);

         */

        //var sbList = stringStream.map(StringBuilder::new).collect(Collectors.toList());
        //System.out.println(sbList);
    }
}
