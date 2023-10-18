package org.example.inters.vladimirkutyavin;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //Найти ближайшее число к заданному из массива:
        int[] arr = new int[]{2, 5, 6, 7, 8, 8, 9};

        System.out.println(findClosest(arr, 5)); //5
        System.out.println(findClosest(arr, 11)); //9
        System.out.println(findClosest(arr, 4)); //5
        System.out.println(findClosest10(arr, 4));


        //Каждая буква алфавита имеет свое весовое значение в зависимости от ее позиции: a = 1, b = 2, c = 3, ...
        //
        //Напишите функцию `String getHighestScoringWord(String str)`, которая возвращает слово с наибольшим весовым коэффициентом.
        //Если присутствует несколько слов с одним весовым коэффициентом необходимо вернуть первое слово, которое присутствует во входной строке.
        //* предложения в нижнем регистре
        //
        //`getHighestScoringWord("man i need a taxi up to ubud") -> "taxi"`
        //
        //`getHighestScoringWord("what time are") -> "what"
    }


    /*private static String getHighestScoringWord(String s) {

        return Arrays.stream(s.split(" "))
                .map(s -> s.chars())
                .filter(c -> c.sum() > 0)
                .map(c1 -> c1.toString())
                .findAny().orElse(" ");*/




        /*
          return Arrays.stream(words)
                .reduce((s, s2) -> s.chars().reduce(Integer::sum).orElse(-1) > s2.chars().reduce(Integer::sum).orElse(-1) ? s : s2)
                .orElseThrow(() -> new RuntimeException("There is no words"));
    }


return Arrays.stream(sentence.split(" "))
.max(Comparator.comparingInt(e -> e.chars().sum()))
.orElse("");
         */


    //из массива чисел сделать мап - ключи число+hello и значение количество вхождений
    //int [] array = {1, 2, 4, 12, 3, 4, 4, 3, 89, 1, 5, 5, 5, 7, 7, 7};
    //output Map<String, Integer>, отсортирован по ключу
    //{1-hello=2, 12-hello=1, 2-hello=1, 3-hello=2, 4-hello=3, 5-hello=3, 7-hello=3, 89-hello=1}

// найти все числа в диапозоне от 0 до 1000 которые деляться без оcтатка на 3 и не деляться на 5, при этом сумма цифр числа должна быть меньше 10


    private static int findClosest(int[] arr, int searchInt) {
        /*return IntStream.range(0, arr.length)
                .min(i -> Math.abs(searchInt - arr[i]));*/
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("error");
        }
        int delta = Math.abs(arr[0] - searchInt);
        int targetInt = arr[0];


        for (int i = 1; i < arr.length; i++) {
            /*if(arr[i] == searchInt){
                return arr[i];
            }*/

            if (Math.abs(arr[i] - searchInt) < delta) { //
                targetInt = arr[i];
                delta = Math.abs(arr[i] - searchInt);
            }

        }
        return targetInt;
    }


    private static int findClosest2(int[] arr, int searchInt) {
        return Arrays.stream(arr)
                .reduce((a, b) -> Math.abs(a - searchInt) < Math.abs(b - searchInt) ? a : b)
                .orElse(0);
    }

    private static int findClosest10 (int[] arr, int searchInt) {
        return Arrays.stream(arr)
                .boxed()
                .min(Comparator.comparingInt(a -> Math.abs(a - searchInt)))
                .orElse(0);
    }


    public static String getHighestScoringWord3(String str) {
        return Arrays.stream(str.split(" "))
                .max((word1, word2) -> word1
                        .chars()
                        .map(ch -> ch - 'a' + 1)
                        .sum() - word2
                        .chars()
                        .map(ch -> ch - 'a' + 1)
                        .sum())
                .orElse("");
    }


}


@AllArgsConstructor
class Human {
    private String name;
}
