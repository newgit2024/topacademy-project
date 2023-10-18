package org.example.innotech.trueview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListForEach {
    public static void main(String[] args) {
        var listtt = IntStream.range(0, 10)
                .boxed()
                .collect(Collectors.toList());

        listtt.forEach(System.out::println);
        Iterator<Integer> iterator = listtt.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        listtt.forEach(System.out::println);

    }
}
