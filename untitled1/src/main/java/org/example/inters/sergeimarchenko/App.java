package org.example.inters.sergeimarchenko;

import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        Stream.of("E", "D", "C", "B", "A")
                .peek(System.out::print) //1 - nothing
                .sorted() //3 EDCBAABCDE
                .forEach(System.out::print); //2 -EEDDCCBBAA

        System.out.println("--------");
        Stream.of("E", "D", "C", "B", "A")
                .peek(System.out::print)
                .anyMatch(n -> n.equals("C"));//1 EDC

    }
}
