package org.example.inters.leonidryzhik;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPIExample {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 12, 6, 4};

        Map<String, Long> result = Arrays.stream(numbers)
                .boxed() // Преобразование int в Integer для использования Collectors.groupingBy
                .collect(Collectors.groupingBy(
                        num -> num + " Hello",
                        Collectors.counting()
                ));

        // Вывод результата
        for (Map.Entry<String, Long> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

