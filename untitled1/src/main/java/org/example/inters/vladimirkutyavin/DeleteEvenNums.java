package org.example.inters.vladimirkutyavin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class DeleteEvenNums {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        removeEvenNumbers2(numbers);

        removeEvenNumbers(numbers);

        // Выводим результат
        System.out.println(numbers);
    }




    public static void removeEvenNumbers(ArrayList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }
        }
    }

    public static void removeEvenNumbers2(ArrayList<Integer> list) {
        System.out.println(list.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList()));

    }
}

