package org.example.beeline.mikhailkonchyts.mikhailkonchyts.onetothousand;

//Вот как это можно сделать на Java:

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static List<Integer> findNums() {
        return IntStream.range(0, 1000)
                .filter(n -> n % 3 == 0 && n % 5 != 0 &&
                        String.valueOf(n)
                                .chars()
                                .mapToObj(c -> (char) c)
                                .map(Character::getNumericValue)
                                .collect(Collectors.summingInt(i -> i)) < 10)
                .boxed()
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<Integer> numbers = findNumbers2();
        System.out.println(numbers);
        System.out.println(findNums());
    }

    private static List<Integer> findNumbers() {
        return IntStream.rangeClosed(0, 1000)
                .filter(num -> num % 3 == 0 && num % 5 != 0 && num < 10)
                .boxed()
                .collect(Collectors.toList());
    }


    private static List<Integer> findNumbers2() {
        return IntStream.rangeClosed(0, 1000)
                .filter(num -> num % 3 == 0 && num % 5 != 0 &&
                        String.valueOf(num)
                                .chars()
                                .map(Character::getNumericValue)
                                .sum() < 10)
                .boxed()
                .collect(Collectors.toList());
    }
}
//В этом коде мы используем `IntStream.rangeClosed(0, 1000)` для генерации чисел в диапазоне от 0 до 1000 включительно. Затем мы фильтруем числа с помощью `.filter`, чтобы выбрать только те, которые делятся на 3 без остатка и не делятся на 5, и значение меньше 10. Наконец, мы используем `.boxed()` для преобразования `IntStream` в `Stream<Integer>` и `.collect(Collectors.toList())` для сбора результатов в список.
