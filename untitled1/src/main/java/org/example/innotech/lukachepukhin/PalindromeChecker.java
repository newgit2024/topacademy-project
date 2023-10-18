package org.example.innotech.lukachepukhin;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PalindromeChecker {
    public static boolean isPalindrome(String input) {
        // Удаляем все символы, кроме букв и цифр, и переводим в нижний регистр
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleanedInput.length() - 1;

        while (left < right) {
            if (cleanedInput.charAt(left) != cleanedInput.charAt(right)) {
                return false; // Не является палиндромом
            }
            left++;
            right--;
        }

        return true; // Является палиндромом
    }



    private static boolean isPalindromeStream(String str) {
        String reverseStr = str.chars()
                .mapToObj(c -> (char)c)
                .sorted(Comparator.reverseOrder())
                .map(Object::toString)
                .collect(Collectors.joining());
        return str.equals(reverseStr);
    }

    private static boolean isPalindromeRange(String str) {
        int length = str.length();
        return IntStream.range(0, length / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(length - i - 1));
    }


    public static void main(String[] args) {
        String input1 = "A man, a plan, a canal, Panama";
        String input2 = "racecar";
        String input3 = "hello";

        System.out.println(input1 + " is a palindrome: " + isPalindrome(input1)); // true
        System.out.println(input2 + " is a palindrome: " + isPalindrome(input2)); // true
        System.out.println(input3 + " is a palindrome: " + isPalindrome(input3)); // false
    }
}

class PalindromeCheckerNumber {
    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reverse = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            reverse = reverse * 10 + lastDigit;
            number /= 10;
        }

        return originalNumber == reverse;
    }

    private static boolean isPalindromeStream(int number) {
        String strNumber = Integer.toString(number);
        String reverseStrNumber = strNumber.chars()
                .mapToObj(c -> (char)c)
                .sorted(Comparator.reverseOrder())
                .map(Object::toString)
                .collect(Collectors.joining());
        return strNumber.equals(reverseStrNumber);
    }

    public static void main(String[] args) {
        int number1 = 12321;
        int number2 = 12345;
        int number3 = 1221;

        System.out.println(number1 + " is a palindrome: " + isPalindrome(number1)); // true
        System.out.println(number2 + " is a palindrome: " + isPalindrome(number2)); // false
        System.out.println(number3 + " is a palindrome: " + isPalindrome(number3)); // true
    }
}
