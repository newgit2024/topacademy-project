package org.example.selftraining.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App2 {
    public static void main(String[] args) {
        IntStream.range(0,10)
                .sum();

        IntStream.range(0,10)
                .min()
                .orElse(-1);

        IntStream.range(0,10)
                .boxed()
                .max(Integer::compareTo)
                .orElse(-1);

        Stream.generate(()->"Hello")
                .limit(10)
                .count();


        // //из массива чисел сделать мап - ключи число+hello и значение количество вхождений
        //        //int [] array = {1, 2, 4, 12, 3, 4, 4, 3, 89, 1, 5, 5, 5, 7, 7, 7};
        //        //output Map<String, Integer>, отсортирован по ключу
        //        //{1-hello=2, 12-hello=1, 2-hello=1, 3-hello=2, 4-hello=3, 5-hello=3, 7-hello=3, 89-hello=1}

        IntStream.range(0,1)
                .boxed()
                .collect(Collectors.toMap(i -> "Hello" + i, i -> i, Integer::sum));

        System.out.println("-------" + Arrays.stream(new int []{1, 2, 4, 12, 3, 4, 4, 3, 89, 1, 5, 5, 5, 7, 7, 7})
                .boxed()
                .collect(Collectors.groupingBy(i -> "Hello" + i, Collectors.counting())));


        IntStream.range(0,1000)
                .boxed()
                .filter(i -> i % 3 == 0 && i % 5 != 0 && getSumOfDigits(i) < 10)
                .forEach(System.out::println);


        IntStream.rangeClosed(0, 1000)
                .filter(num -> num % 3 == 0 && num % 5 != 0 && String.valueOf(num)
                        .chars()
                        .map(Character::getNumericValue)
                        .sum() < 10)
                .forEach(System.out::println);


        IntStream.rangeClosed(0, 1000)
                .filter(num -> num % 3 == 0 && num % 5 != 0 && String.valueOf(num)
                        .chars()
                        .reduce(0, (sum, digit) -> sum + Character.getNumericValue(digit)) < 10)
                .forEach(System.out::println);


    }
    private static int getSumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}

class Person2 {
    private final int id;
    private final String name;
    private final int age;

    private final double salary;

    private final Gender gender;

    private final List<Account> accounts;

    Person2(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = 1000;
        gender = Gender.MALE;
        accounts = List.of(new Account(), new Account(), new Account());
    }

    Person2(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        gender = Gender.FEMALE;
        accounts = List.of(new Account(), new Account(), new Account());
    }

    Person2(int id, String name, int age, double salary, Gender gender) {
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
