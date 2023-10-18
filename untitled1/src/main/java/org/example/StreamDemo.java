package org.example;

import java.util.Random;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {



        long nums = Stream.generate(() ->
                new Human(new Random().nextInt(100), Gender.randomGender()))
                .limit(100)
                .filter(h -> (h.getAge() >= 18 && h.getAge() <= 60) && h.getGender().equals(Gender.Female) ||
                (h.getAge() >= 18 && h.getAge() <= 65) && h.getGender().equals(Gender.Male))
                .count();



        System.out.println(nums);

    }
}


class Human {

    private int age;
    private Gender gender;

    public Human() {
    }

    public Human(int age, Gender gender) {
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", gender=" + gender +
                '}';
    }
}


enum Gender {
    Male,
    Female;

    private static final Random PRNG = new Random();

    public static Gender randomGender() {
        Gender[] genders = values();
        return genders[PRNG.nextInt(genders.length)];
    }
}
