package org.example.inters.vitalimiloshnikov;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//найти все числа в диапазоне от 0 до 1000 которые делятся без остатка на 3 и не делятся на 5 при этом сумма должна быть меньше 10
public class A {
    public static List<Integer> findNumbers() {
        List<Integer> numbers = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i <= 1000; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                if (sum + i < 10) {
                    numbers.add(i);
                    sum += i;
                } else {
                    break;
                }
            }
        }
        return numbers;
    }


    public static List<Integer> findNumbers2() {
        return IntStream.rangeClosed(0, 1000)
                .filter(i -> i % 3 == 0 && i % 5 != 0)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
    }


    public static List<Integer> findNumbers3() {
        return IntStream.rangeClosed(0, 1000)
                .filter(i -> i % 3 == 0 && i % 5 != 0 && sumOfDigits(i) < 10)
                .boxed()
                .collect(Collectors.toList());
    }

    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private static int sumOfDigits2(int number) {
        return String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }


    public static List<Integer> findNumbers4() {
        return IntStream.rangeClosed(0, 1000)
                .filter(i -> i % 3 == 0 && i % 5 != 0 && String.valueOf(i)
                        .chars()
                        .map(Character::getNumericValue)
                        .sum() < 10)
                .boxed()
                .collect(Collectors.toList());
    }



    //вывести ближайшее к 10 число из массива
    public static int findClosestTo10(List<Integer> numbers) {
        return Collections.min(numbers, Comparator.comparingInt(i -> Math.abs(i - 10)));
    }

    public static int findClosestTo10_2(List<Integer> numbers) {
        Objects.requireNonNull(numbers, "List of numbers cannot be null");
        return Collections.min(numbers, Comparator.comparingInt(i -> Math.abs(i - 10)));
    }




}
