package org.example.selftraining.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceDemo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(IntStream.of(nums)
                .reduce(0, Integer::sum));

        System.out.println(DoubleStream.of(1.1, 2.2, 3.3, 4.4)
                .reduce(1, (a, b) -> a * b));

        System.out.println(IntStream.of(1, 2, 3, 4)
                .reduce(0, (a, b) -> a > b ? a : b));

        System.out.println(IntStream.of(1, 2, 3, 4)
                .reduce(0, (a, b) -> Math.max(a, b)));

        //

        System.out.println(IntStream.of(1, 2, 3, 4)
                .reduce(0, Math::max));
        System.out.println(IntStream.of(1, 2, 3, 4)
                .reduce(Integer::max).orElse(0));

        System.out.println(Stream.of("a", "b", "c", "d")
                .reduce(String::concat).orElse("hi"));

        int[] ints = {1, 2, 3, 4};
        System.out.println(IntStream.of(ints)
                .asDoubleStream()
                .reduce(0, (a, b) -> a + b / ints.length));

        System.out.println(IntStream.of(1, 2, 3, 4)
                .reduce(Integer::min).orElse(0));


        List<String> strings = Arrays.asList("Hello", "World", "Java");
        List<Integer> lengths = strings.stream().map(String::length).collect(Collectors.toList());
        System.out.println(lengths); // Выведет: [5, 5, 4]


        System.out.println(IntStream.of(1, 2, 3, 4)
                .allMatch(a -> a > 0));

        System.out.println(IntStream.of(1, 2, 3, 4)
                .anyMatch(a -> a > 0));


        System.out.println(IntStream.of(1, 2, 3, 4)
                .reduce((a, b) -> a * a + b * b));

        System.out.println(IntStream.of(1, 2, 3, 4)
                .map(a -> a * a)
                .sum());


        System.out.println(Stream.of("A", "b", "c", "d", "AAA")
                .filter(s -> s.toUpperCase().startsWith("A"))
                .collect(Collectors.toList()));

        System.out.println(Stream.of("A", "b", "c", "d", "AAA")
                .reduce(((s, s2) -> String.join(",", s, s2))).orElse(" "));


        System.out.println(IntStream.of(1, 2, 3, 4)
                .filter(a -> a % 2 == 0)
                .reduce(Integer::sum).orElse(0));

        System.out.println(Stream.of("A", "b", "c", "d", "AAA")
                .map(s -> s.toUpperCase().charAt(0))
                .collect(Collectors.toList()));


        System.out.println(IntStream.of(1, 2, 3, 4)
                .filter(a -> a % 2 == 0)
                .map(n -> n * n)
                .reduce(Integer::sum).orElse(0));


        var list = Arrays.asList(Arrays.asList("A", "b", "c", "d", "AAA"), Arrays.asList("A", "b", "c", "d", "AAA"))
                .stream()
                .flatMap(s -> Arrays.stream(s.toArray()))
                .collect(Collectors.toList());
        System.out.println(list);

        var sett = Arrays.asList(Arrays.asList("A", "b", "c", "d", "AAA", "AAA"), Arrays.asList("A", "b", "c", "d", "AAA"))
                .stream()
                .flatMap(s -> Arrays.stream(s.toArray()))
                .collect(Collectors.toSet());
        System.out.println(sett);

//Преобразовать список строк в список всех уникальных символов:
        System.out.println(Arrays.asList("A", "b", "c", "d", "AAA", "AAA")
                .stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet()));


        System.out.println(Arrays.stream("Arrays.asList(A, b, c, d, AAA, AAA".split(" "))
                .collect(Collectors.joining(" = ")));


        System.out.println(Arrays.asList(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4})
                .stream().flatMapToInt(s -> Arrays.stream(s)).sum());
        System.out.println(Stream.of(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4})
                .flatMapToInt(Arrays::stream).sum());


        System.out.println(Stream.of(new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9})
                .flatMapToInt(Arrays::stream)
                .map(i -> i * i)
                .sum());

        System.out.println(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9))
                .stream()
                .flatMapToInt(lll -> lll.stream()
                        .mapToInt(n -> n * n))
                .sum()); // Выведет: 285

        System.out.println(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9))
                .stream()
                .flatMap(lll -> lll.stream()
                        .map(n -> n * 2))
                .collect(Collectors.toList())); // Выведет: 285


        System.out.println(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9))
                .stream()
                .flatMap(Collection::stream)
                .sorted()
                .collect(Collectors.toList()));


        int[] array = {1, 2, 3, 4, 5};

        int sumOfSquares = Arrays.stream(array)
                .reduce(0, (acc, num) -> acc + num * num);

        System.out.println("Сумма квадратов элементов: " + sumOfSquares);


        System.out.println(Arrays.asList("A", "b", "c", "d", "AAA", "AAA")
                .stream()
                .flatMapToInt(String::chars)
                .sorted()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toSet()));
    }

}


//1. Найти сумму всех элементов в массиве целых чисел:
//
//```java
//int[] array = {1, 2, 3, 4, 5};
//int sum = IntStream.of(array).reduce(0, (a, b) -> a + b);
//System.out.println(sum); // Выведет: 15
//```
//
//2. Найти произведение всех элементов в списке дробных чисел:
//
//```java
//List<Double> numbers = Arrays.asList(1.5, 2.5, 3.5, 4.5);
//double product = numbers.stream().reduce(1.0, (a, b) -> a * b);
//System.out.println(product); // Выведет: 79.6875
//```
//
//3. Найти наибольший элемент в массиве целых чисел:
//
//```java
//int[] array = {10, 5, 8, 15, 3};
//int max = IntStream.of(array).reduce(Integer::max).orElse(0);
//System.out.println(max); // Выведет: 15
//```
//
//4. Объединить все строки из списка в одну строку:
//
//```java
//List<String> strings = Arrays.asList("Hello", " ", "World", "!");
//String result = strings.stream().reduce((a, b) -> a + b).orElse("");
//System.out.println(result); // Выведет: Hello World!
//```
//
//5. Найти среднее значение всех элементов в массиве целых чисел:
//
//```java
//int[] array = {10, 5, 8, 15, 3};
//OptionalDouble average = IntStream.of(array).average();
//if (average.isPresent()) {
//    System.out.println(average.getAsDouble()); // Выведет: 8.2
//}
//```
//
//6. Найти наименьший элемент в списке целых чисел:
//
//```java
//List<Integer> numbers = Arrays.asList(10, 5, 8, 15, 3);
//int min = numbers.stream().reduce(Integer::min).orElse(0);
//System.out.println(min); // Выведет: 3
//```
//
//7. Посчитать количество элементов в массиве целых чисел:
//
//```java
//int[] array = {1, 2, 3, 4, 5};
//int count = IntStream.of(array).reduce(0, (a, b) -> a + 1);
//System.out.println(count); // Выведет: 5
//```
//
//8. Преобразовать список строк в список их длин:
//
//```java
//List<String> strings = Arrays.asList("Hello", "World", "Java");
//List<Integer> lengths = strings.stream().map(String::length).collect(Collectors.toList());
//System.out.println(lengths); // Выведет: [5, 5, 4]
//```
//
//9. Проверить, все ли элементы списка являются положительными:
//
//```java
//List<Integer> numbers = Arrays.asList(1, 2, 3, 4, -5);
//boolean allPositive = numbers.stream().allMatch(n -> n > 0);
//System.out.println(allPositive); // Выведет: false
//```
//
//10. Проверить, есть ли хотя бы один отрицательный элемент в списке:
//
//```java
//List<Integer> numbers = Arrays.asList(1, 2, 3, 4, -5);
//boolean hasNegative = numbers.stream().anyMatch(n -> n < 0);
//System.out.println(hasNegative); // Выведет: true
//```
//
//11. Найти сумму квадратов всех элементов в массиве целых чисел:
//
//```java
//int[] array = {1, 2, 3, 4, 5};
//int sumOfSquares = IntStream.of(array).map(n -> n * n).sum();
//System.out.println(sumOfSquares); // Выведет: 55
//```
//
//12. Отфильтровать список строк, оставив только те, которые начинаются с буквы "A":
//
//```java
//List<String> strings = Arrays.asList("Apple", "Banana", "Orange", "Kiwi");
//List<String> filteredStrings = strings.stream().filter(s -> s.startsWith("A")).collect(Collectors.toList());
//System.out.println(filteredStrings); // Выведет: [Apple]
//```
//
//13. Объединить элементы списка строк через запятую:
//
//```java
//List<String> strings = Arrays.asList("Apple", "Banana", "Orange");
//String joined = strings.stream().collect(Collectors.joining(", "));
//System.out.println(joined); // Выведет: Apple, Banana, Orange
//```
//
//14. Найти сумму всех четных чисел в массиве:
//
//```java
//int[] array = {1, 2, 3, 4, 5};
//int sumOfEven = IntStream.of(array).filter(n -> n % 2 == 0).sum();
//System.out.println(sumOfEven); // Выведет: 6
//```
//
//15. Преобразовать список строк в список их заглавных версий:
//
//```java
//List<String> strings = Arrays.asList("apple", "banana", "orange");
//List<String> upperCaseStrings = strings.stream().map(String::toUpperCase).collect(Collectors.toList());
//System.out.println(upperCaseStrings); // Выведет: [APPLE, BANANA, ORANGE]
//```
//
//16. Найти сумму квадратов всех четных чисел в массиве:
//
//```java
//int[] array = {1,


//1. Объединить несколько списков в один:
//
//```java
//List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
//List<Integer> combinedList = lists.stream().flatMap(Collection::stream).collect(Collectors.toList());
//System.out.println(combinedList); // Выведет: [1, 2, 3, 4, 5, 6, 7, 8, 9]
//```
//
//2. Преобразовать список списков в список всех уникальных элементов:
//
//```java
//List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 5), Arrays.asList(5, 6, 7));
//List<Integer> uniqueElements = lists.stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());
//System.out.println(uniqueElements); // Выведет: [1, 2, 3, 4, 5, 6, 7]
//```
//
//3. Преобразовать список строк в список всех уникальных символов:
//
//```java
//List<String> strings = Arrays.asList("hello", "world", "java");
//List<Character> uniqueChars = strings.stream()
//        .flatMapToInt(CharSequence::chars)
//        .distinct()
//        .mapToObj(ch -> (char) ch)
//        .collect(Collectors.toList());
//System.out.println(uniqueChars); // Выведет: [h, e, l, o, w, r, d, j, a, v]
//```
//
//4. Разбить строку на слова и объединить их в одну строку:
//
//```java
//String sentence = "The quick brown fox jumps over the lazy dog";
//String result = Arrays.stream(sentence.split(" ")).collect(Collectors.joining(", "));
//System.out.println(result); // Выведет: The, quick, brown, fox, jumps, over, the, lazy, dog
//```
//
//5. Найти сумму всех элементов в массиве списков:
//
//```java
//List<Integer> list1 = Arrays.asList(1, 2, 3);
//List<Integer> list2 = Arrays.asList(4, 5, 6);
//List<Integer> list3 = Arrays.asList(7, 8, 9);
//int sum = Stream.of(list1, list2, list3).flatMapToInt(List::stream).sum();
//System.out.println(sum); // Выведет: 45
//```
//
//6. Найти сумму квадратов всех элементов в списке списков:
//
//```java
//List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
//int sumOfSquares = lists.stream().flatMapToInt(list -> list.stream().mapToInt(n -> n * n)).sum();
//System.out.println(sumOfSquares); // Выведет: 285
//```
//
//7. Преобразовать список списков в список всех элементов, умноженных на 2:
//
//```java
//List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
//List<Integer> doubledElements = lists.stream().flatMap(list -> list.stream().map(n -> n * 2)).collect(Collectors.toList());
//System.out.println(doubledElements); // Выведет: [2, 4, 6, 8, 10, 12, 14, 16, 18]
//```
//
//8. Объединить несколько списков в один и отсортировать его:
//
//```java
//List<List<Integer>> lists = Arrays.asList(Arrays.asList(3, 2, 1), Arrays.asList(6, 5, 4), Arrays.asList(9, 8, 7));
//List<Integer> combinedAndSorted = lists.stream().flatMap(Collection::stream).sorted().collect(Collectors.toList());
//System.out.println(combinedAndSorted); // Выведет: [1, 2, 3, 4, 5, 6, 7, 8, 9]
//```
//
//9. Разбить список строк на символы и отсортировать их:
//
//```java
//List<String> strings = Arrays.asList("hello", "world", "java");
//List<Character> sortedChars = strings.stream()
//        .flatMapToInt(CharSequence::chars)
//        .sorted()
//        .mapToObj(ch -> (char) ch)
//        .collect(Collectors.toList());
//System.out.println(sortedChars); // Выведет: [
//
//a, a, d, e, h, j, l, l, o, o, r, v, w]
//```
//
//10. Преобразовать список строк в список всех уникальных символов в верхнем регистре:
//
//```java
//List<String> strings = Arrays.asList("hello", "world", "java");
//List<Character> uniqueUpperCaseChars = strings.stream()
//        .flatMapToInt(CharSequence::chars)
//        .distinct()
//        .mapToObj(ch -> Character.toUpperCase((char) ch))
//        .collect(Collectors.toList());
//System.out.println(uniqueUpperCaseChars); // Выведет: [H, E, L, O, W, R, D, J, A, V]
//```
//
//11. Найти максимальное значение среди всех элементов в списке списков:
//
//```java
//List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
//int max = lists.stream().flatMap(list -> list.stream().mapToInt(Integer::intValue)).max().orElse(0);
//System.out.println(max); // Выведет: 9
//```
//
//12. Преобразовать список списков в список всех элементов, возводящихся в квадрат:
//
//```java
//List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
//List<Integer> squaredElements = lists.stream().flatMap(list -> list.stream().map(n -> n * n)).collect(Collectors.toList());
//System.out.println(squaredElements); // Выведет: [1, 4, 9, 16, 25, 36, 49, 64, 81]
//```
//
//13. Найти среднее значение всех элементов в списке списков:
//
//```java
//List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
//OptionalDouble average = lists.stream().flatMapToInt(list -> list.stream().mapToInt(Integer::intValue)).average();
//if (average.isPresent()) {
//    System.out.println(average.getAsDouble()); // Выведет: 5.0
//}
//```
//
//14. Отфильтровать список списков, оставив только те списки, которые содержат четные числа:
//
//```java
//List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
//List<List<Integer>> evenLists = lists.stream().filter(list -> list.stream().anyMatch(n -> n % 2 == 0)).collect(Collectors.toList());
//System.out.println(evenLists); // Выведет: [[4, 5, 6], [7, 8, 9]]
//```
//
//15. Преобразовать список списков в список всех элементов, возводящихся в степень:
//
//```java
//List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
//List<Integer> poweredElements = lists.stream().flatMap(list -> list.stream().map(n -> (int) Math.pow(n, 2))).collect(Collectors.toList());
//System.out.println(poweredElements); // Выведет: [1, 4, 9, 16, 25, 36, 49, 64, 81]
//```
//
//16. Разбить список строк на символы и преобразовать их в список их ASCII-кодов:
//
//```java
//List<String> strings = Arrays.asList("hello", "world", "java");
//List<Integer> asciiCodes = strings.stream()
//        .flatMapToInt(CharSequence::chars)
//        .boxed()
//        .collect(Collectors.toList());
//System.out.println(asciiCodes); // Выведет: [104, 101, 108, 108, 111, 119, 111, 114, 108, 100, 106, 97, 118, 97]
//```
//
//17. Преобразовать список списков в список всех элементов, возводящихся в куб:
//
//```java
//List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
//List<Integer> cubedElements = lists.stream().flatMap(list -> list.stream().map(n
//
// -> n * n * n)).collect(Collectors.toList());
//System.out.println(cubedElements); // Выведет: [1, 8, 27, 64, 125, 216, 343, 512, 729]
//```
//
//18. Преобразовать список строк в список всех символов на нечетных позициях:
//
//```java
//List<String> strings = Arrays.asList("hello", "world", "java");
//List<Character> oddPositionChars = strings.stream()
//        .flatMapToInt(CharSequence::chars)
//        .filter((ch, index) -> index % 2 != 0)
//        .mapToObj(ch -> (char) ch)
//        .collect(Collectors.toList());
//System.out.println(oddPositionChars); // Выведет: [e, l, o, o, l, d, a]
//```
//
//19. Отфильтровать список списков, оставив только те списки, которые содержат хотя бы одно нечетное число:
//
//```java
//List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 6, 8), Arrays.asList(7, 8, 9));
//List<List<Integer>> listsWithOddNumber = lists.stream().filter(list -> list.stream().anyMatch(n -> n % 2 != 0)).collect(Collectors.toList());
//System.out.println(listsWithOddNumber); // Выведет: [[1, 2, 3], [7, 8, 9]]
//```
//
//20. Преобразовать список строк в список их длин и отсортировать его в обратном порядке:
//
//```java
//List<String> strings = Arrays.asList("hello", "world", "java");
//List<Integer> lengths = strings.stream()
//        .map(String::length)
//        .sorted(Comparator.reverseOrder())
//        .collect(Collectors.toList());
//System.out.println(lengths); // Выведет: [5, 5, 4]
//```