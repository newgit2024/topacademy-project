package functional.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        List<String> lines = Arrays.asList("hello", "what's up", "how are you", "bye");
        Sequence<String> sequence = new Sequence<>(lines);
        List<String> filteredList = sequence.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.indexOf(' ') != -1;
            }
        });

        System.out.println(filteredList);
        List<Integer> result = sequence.map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.indexOf('o');
            }
        });

        System.out.println(result);

        sequence.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
