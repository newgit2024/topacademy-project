package functional.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Sequence<T> {
    private List<T> elements;

    public Sequence(List<T> elements) { //List<Integer> elements
        this.elements = elements;
    }
    public <R> List<R> map (Function<T, R> function){
        List<R> result = new ArrayList<>();
        for (T element : elements){
            result.add(function.apply(element));
        }
        return result;
    }

    public List<T> filter (Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        for (T element : elements){
            if(predicate.test(element)){
                result.add(element);
            }
        }
        return result;
    }

    public void forEach(Consumer<T> consumer){
        for (T element : elements){
            consumer.accept(element);
        }
    }
}
