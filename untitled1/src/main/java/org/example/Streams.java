package org.example;

import java.util.List;
import java.util.Map;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        //Фильтрация уникальных элементов в с списке:

        List.of("1", "2", "3", "4", "1").stream().distinct().collect(Collectors.toList());

        ArrayList<Integer> numbers = (ArrayList<Integer>) List.of(1, 2, 3, 3, 5, 6);
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        //Поиск суммы квадратов всех чисел в с//Писке:

        List.of(1,2,3,5).stream().mapToInt(a -> a * a).sum();



        int sumOfSquares = numbers.stream()
                .mapToInt(n -> n * n)
                .sum();
        System.out.println(sumOfSquares);
        //Проверка, содержит ли с//Писок хотя бы одно отрицательное число:


        Stream.of(1,2,3,-1,0).anyMatch(a -> a < 0);


        boolean hasNegativeNumber = numbers.stream()
                .anyMatch(n -> n < 0);

        System.out.println(hasNegativeNumber);
        //Вычисление среднего значения чисел в с//Писке:

        Stream.of(1,2,3,-1,0)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);


        double average = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
        System.out.println(average);
        //Сортировка списка строк в обратном алфавитном порядке:


        Stream.of("z", "b", "c", "d").sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        List<String> strings = List.of("a", "b", "c", "d");
        List<String> sortedReverse = strings.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(sortedReverse);
        //Объединение всех строк из с//Писка в одну строку через за//Пятую:

        String.join(",", "a", "b", "c");


        String mergedString = strings.stream()
                .collect(Collectors.joining(","));
        //ГруПировка объектов //По их свойству и //Подсчет количества в каждой гру//П//Пе:

        System.out.println(Stream.of(new Human(33, Gender.Male), new Human(32, Gender.Female))
                .collect(Collectors.groupingBy(Human::getAge, Collectors.counting())));

/*
        Map<String, Long> groupCount = objects.stream()
                .collect(Collectors.groupingBy(Object::getProperty, Collectors.counting()));
        //Получение //Первых 3 элементов из с//Писка:




 */
        Stream.of("z", "b", "c", "d").limit(3).collect(Collectors.toList());


        List<Integer> firstThree = numbers.stream()
                .limit(3)
                .collect(Collectors.toList());
        //Про//Пуск //Первых 5 элементов в с//Писке:


        Stream.of("z", "b", "c", "d").skip(2).collect(Collectors.toList());


        List<Integer> skippedFive = numbers.stream()
                .skip(5)
                .collect(Collectors.toList());
        //Поиск наибольшей строки в с//Писке:

        Stream.of("z", "b", "c", "d").max(Comparator.comparingInt(String::length));





        Optional<String> longestString = strings.stream()
                .max(Comparator.comparingInt(String::length));
        //Объединение двух с//Писков без //Повторяющихся элементов:



        Stream.concat(List.of("a", "b").stream(), List.of("a", "b", "c").stream()).distinct().collect(Collectors.toList());


        //List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
        //Вычисление суммы всех чисел, ис//Пользуя //Параллельные вычисления:

        Stream.of(1,2,3,-1,0).parallel().reduce(0, Integer::sum);




        int sum = numbers.parallelStream()
                .reduce(0, Integer::sum);
        //Поиск минимального и максимального значения в с//Писке:

        Stream.of(1,2,3,-1,0).max(Comparator.naturalOrder()).orElse(0);



        Optional<Integer> min = numbers.stream()
                .min(Comparator.naturalOrder());

        Optional<Integer> max = numbers.stream()
                .max(Comparator.naturalOrder());
        //Преобразование с//Писка объектов в Map, ис//Пользуя свойство в качестве ключа:

        Stream.of(new Human(33, Gender.Male), new Human(32, Gender.Female))
                .collect(Collectors.toMap(Human::getAge, Function.identity()));






        //Map<String, Object> map = objects.stream().collect(Collectors.toMap(Object::getProperty, Function.identity()));
        //Груggировка объектов //По условию и выбор наибольшего значения в каждой гру//П//Пе:
        
        /*


Stream.of("dffdfdfd", "gfkjfgjkfgjkfg", "fggfgfgf", "fdfdf", "dfdfdfdfdfdfd").max(groupBy(Comparator.naturalOrder()).)






        /*
        Map<String, Integer> maxValues = objects.stream()
                .collect(Collectors.groupingBy(Object::getProperty,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Object::getValue)),
                                Optional::get)
                ));
        //Преобразование с//Писка объектов в с//Писок их свойств:
        
        
        List<String> properties = objects.stream()
                .map(Object::getProperty)
                .collect(Collectors.toList());
        //Проверка, все ли элементы с//Писка удовлетворяют о//Пределенному условию:
        
        
        boolean allPositive = numbers.stream()
                .allMatch(n -> n > 0);
        Вычисление суммы всех чисел с ис//Пользованием начального значения и бинарной о//Перации:
        
        
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        Разделение с//Писка на две гру//П//Пы: четные и нечетные числа:
        
        
        Map<Boolean, List<Integer>> evenOddMap = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        List<Integer> evenNumbers = evenOddMap.get(true);
        List<Integer> oddNumbers = evenOddMap.get(false);
        Вычисление суммы квадратов четных чисел:
        
        
        int sumOfSquaresEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();
        Это лишь несколько //Примеров сложных о//Пераций, которые можно вы//Полнять с ис//Пользованием Stream API в . Stream API //Предоставляет богатый набор функций для работы с коллекциями и //Потоками данных, //Позволяя удобно и эффективно обрабатывать данные.
    }
}

         */
    }
}
