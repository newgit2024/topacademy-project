package org.example.sberkib.mikhailkonchyts.onetothousand;

//Вот как это можно сделать на Java:

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = findNumbers();
        System.out.println(numbers);
    }

    private static List<Integer> findNumbers() {
        return IntStream.rangeClosed(0, 1000)
                .filter(num -> num % 3 == 0 && num % 5 != 0 && num < 10)
                .boxed()
                .collect(Collectors.toList());
    }
}
//В этом коде мы используем `IntStream.rangeClosed(0, 1000)` для генерации чисел в диапазоне от 0 до 1000 включительно. Затем мы фильтруем числа с помощью `.filter`, чтобы выбрать только те, которые делятся на 3 без остатка и не делятся на 5, и значение меньше 10. Наконец, мы используем `.boxed()` для преобразования `IntStream` в `Stream<Integer>` и `.collect(Collectors.toList())` для сбора результатов в список.
