package org.example.selftraining.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        var list = IntStream.range(1, 10)
                .boxed()
                .collect(Collectors.averagingInt(Integer::intValue));

        var s = Stream.of("a", "b", "c", "d")
                .collect(Collectors.joining(" "));


        var s2 = Stream.of("a", "b", "c", "d")
                .map(String::length)
                .collect(Collectors.toList());

        var ints = IntStream.rangeClosed(1, 20)
                .boxed()
                .collect(Collectors.summingInt(Integer::intValue));
        var ints2 = IntStream.rangeClosed(1, 20)
                .boxed()
                .collect(Collectors.summarizingInt(Integer::intValue)).getMax();

        var ints333 = IntStream.range(1, 10)
                .boxed()
                .collect(Collectors.groupingBy(i -> i % 3));

        var s3 = Stream.of("a", "b", "c", "d")
                .collect(Collectors.groupingBy(String::length));

        var s4 = Stream.of("a", "b", "c", "d")
                .map(String::length)
                .collect(Collectors.summarizingInt(Integer::intValue)).getMax();
        System.out.println(s4);

        var s5 = Stream.of("a", "b", "c", "d")
                .collect(Collectors.minBy(Comparator.comparing(String::length)));

        var s6 = Stream.of(new Person(1, "A", 20),
                        new Person(2, "B", 25),
                        new Person(3, "C", 35))
                .collect(Collectors.groupingBy(Person::getAge));


        var s7 = Stream.of("a", "b", "c", "d", "c")
                .distinct()
                .collect(Collectors.toList());


        var s8 = Stream.of("a", "b", "c", "d", "c")
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        var list33 = Stream.concat(IntStream.range(1, 10)
                                .boxed(),
                        IntStream.range(5, 15)
                                .boxed())
                .distinct()
                .filter(d -> d % 2 == 0)
                .collect(Collectors.toList());

        var s99 = Stream.of("a", "b", "c", "d")
                .filter(str -> str.contains("a"))
                .collect(Collectors.toList());

        var s9999 = Stream.of(new Person(1, "A", 20, 1000),
                        new Person(2, "B", 25, 2000),
                        new Person(3, "C", 35, 4000))
                .collect(Collectors.averagingDouble(Person::getSalary));


        var some = IntStream.rangeClosed(-20, 20)
                .boxed()
                .collect(Collectors.partitioningBy(i -> i > 0));

        System.out.println(some.get(true));


        var s555 = Stream.of("a", "b", "c", "d", "333", "777")
                .filter(sss -> sss.matches("\\d+"))
                .collect(Collectors.toList());

        var s1000 = Stream.of(new Person(1, "A", 20),
                        new Person(2, "B", 25, 2000),
                        new Person(3, "C", 35, 4000))
                .collect(Collectors.groupingBy(Person::getGender));

        var s5551 = Stream.of("a", "b", "c", "d", "333", "777")
                .limit(3)
                .collect(Collectors.joining(" : "));

        var some2 = IntStream.rangeClosed(1, 20)
                .boxed()
                .collect(Collectors.summingInt(integer -> integer * integer));


        var some2222 = (Integer) IntStream.rangeClosed(1, 20)
                .boxed()
                .mapToInt(integer -> integer * integer)
                .sum();

        var s555666 = Stream.of("a", "bdd", "cdd", "ddddd", "333", "777")
                .collect(Collectors.toMap(strr -> strr, String::length));


        var some3332 = IntStream.rangeClosed(1, 20)
                .boxed()
                .collect(Collectors.groupingBy(i -> i % 3));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sumOfSquares = numbers.stream()
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Сумма квадратов чисел: " + sumOfSquares);

        var flatMap1 = Arrays.asList(List.of(1, 2, 3, 4, 5), List.of(1, 2, 3, 4, 5), List.of(1, 2, 3, 4, 5))
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        var flatMap3 = Arrays.asList("hello", "java", "world")
                .stream()
                .flatMap(s1 -> s1.chars()
                        .mapToObj(c -> (char) c))
                .collect(Collectors.toList());

        var fM3 = Arrays.asList(new Person(1, "A", 20),
                        new Person(2, "B", 25, 2000),
                        new Person(3, "C", 35, 4000))
                .stream()
                .flatMap(pp -> pp.getAccounts().stream())
                .collect(Collectors.toList());

        var flatMap4 = Arrays.asList("hello", "java", "world")
                .stream()
                .flatMap(s1 -> s1.chars()
                        .mapToObj(cc -> (char) cc))
                .collect(Collectors.toList());

        var flatMap333 = Arrays.asList("hello", "java", "world")
                .stream()
                .flatMap(s1 -> s1
                        .chars()
                        .distinct()
                        .mapToObj(c -> String.valueOf((char) c)))
                .collect(Collectors.toList());


    }
}

class Person {
    private final int id;
    private final String name;
    private final int age;

    private final double salary;

    private final Gender gender;

    private final List<Account> accounts;

    Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = 1000;
        gender = Gender.MALE;
        accounts = List.of(new Account(), new Account(), new Account());
    }

    Person(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        gender = Gender.FEMALE;
        accounts = List.of(new Account(), new Account(), new Account());
    }

    Person(int id, String name, int age, double salary, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        accounts = List.of(new Account(), new Account(), new Account());
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public Gender getGender() {
        return gender;
    }


    public List<Account> getAccounts() {
        return accounts;
    }
}
