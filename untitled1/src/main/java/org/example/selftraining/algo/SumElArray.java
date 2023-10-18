package org.example.selftraining.algo;

import java.util.stream.IntStream;

public class SumElArray {
    static int[]ints = new int[]{1,2,3,4};
    public static void main(String[] args) {
        intArrayElSum();

        intArrayMax();

        intArrayMin();

        System.out.println(isPalindrom("aboba"));

    }

    private static void intArrayElSum() {
        int sum = 0;
        for (int n:ints) {
            sum += n;
        }
        System.out.println(sum);
    }

    private static void intArrayMax() {
        int max = Integer.MIN_VALUE;
        for (int n:ints) {
            if(n > max){
                max = n;
            }
        }
        System.out.println(max);
    }

    private static void intArrayMin() {
        int min = Integer.MAX_VALUE;
        for (int n:ints) {
            if(n < min){
                min = n;
            }
        }
        System.out.println(min);
    }

    private static boolean isPalindrom(String s){
        var subHalfString = s.substring(0,s.length()/2);
        var sbReversed = String.valueOf(new StringBuilder(s.substring(s.length()/2, s.length())).reverse());

        if(subHalfString == sbReversed){
            return true;
        } else {
            return false;
        }
    }


    private static boolean isPalindrom2(String s){
        int l = 0;
        int r = s.length() -1;
        while(l < r){
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
                l++;
                r--;
            }
        return true;
    }

    public static boolean isPalindrome3(String input) {
        // Преобразуем строку в нижний регистр и удаляем не-буквенно-цифровые символы
        String cleanInput = input.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        // Создаем StringBuilder и добавляем в него преобразованную строку
        StringBuilder reversedInput = new StringBuilder(cleanInput);

        // Используем Stream API для сравнения исходной строки с обратной ей строкой
        return IntStream.range(0, cleanInput.length())
                .allMatch(i -> cleanInput.charAt(i) == reversedInput.charAt(cleanInput.length() - 1 - i));
    }
}
