package functional.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class App2 {
    public static void main(String[] args) {
        List<String> lines = Arrays.asList("hello", "what's up", "how are you", "bye");
        Sequence<String> sequence = new Sequence<>(lines);
        List<String> filteredList = sequence.filter(s -> s.indexOf(' ') != -1);

        System.out.println(filteredList);
        List<Integer> result = sequence.map(s -> s.indexOf('o'));

        System.out.println(result);
        
        sequence.forEach(System.out::println);
    }
}
