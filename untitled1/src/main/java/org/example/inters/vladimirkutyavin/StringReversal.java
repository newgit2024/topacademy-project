package org.example.inters.vladimirkutyavin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringReversal {

    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder(input.length());

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }

        return reversed.toString();
    }

    public static String reverseString2(String input) {
        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }

    public static String reverseStringStream(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .sorted(Comparator.reverseOrder())
                //.map(c -> )
                .collect(Collectors.toList()).toString();
    }

    public static String reverseString4(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            java.util.Collections.reverse(list);
                            return list.stream()
                                    .map(Object::toString)
                                    .collect(Collectors.joining());
                        }));
    }

    public static void main(String[] args) {
        String original = "Hello, World!";
        String reversed = reverseStringStream(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}

