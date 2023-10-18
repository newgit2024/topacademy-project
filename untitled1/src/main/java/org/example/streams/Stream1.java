package org.example.streams;

import java.util.List;

public class Stream1 {
    public static void main(String[] args) {
        List<String> list = List.of(" G", " C", " 0", " A", " C", "", " E", " D");
        long count = list.stream()
                .skip(2)
                .sorted()
                .skip(2).
                distinct()
                .filter(s -> {
                    System.out.println(s);
                    return true;
                })
                .peek(System.out::println)
                .distinct().count();
        System.out.println();
        System.out.println(count);

    }
}
