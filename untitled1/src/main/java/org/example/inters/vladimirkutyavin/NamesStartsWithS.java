package org.example.inters.vladimirkutyavin;



import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NamesStartsWithS {
    public static void main(String[] args) {
        System.out.println(Stream.of(new Person("Zhorik"), new Person ("Sasha"), new Person("Shurik"))
                .map(Person::name)
                .filter(n -> n.startsWith("S"))
                .collect(Collectors.toList()));

    }
}
