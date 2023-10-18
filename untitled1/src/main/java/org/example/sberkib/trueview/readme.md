###
проверка строки на палиндром с исключением не букв из проверки
public class PalindromeCheck {
public static boolean isPalindrome(String str) {
// Удаление не-букв из строки и приведение к нижнему регистру
String cleanStr = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Проверка на палиндром
        int left = 0;
        int right = cleanStr.length() - 1;
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal, Panama!";
        String str2 = "Hello, world!";
        
        System.out.println(isPalindrome(str1)); // Вывод: true
        System.out.println(isPalindrome(str2)); // Вывод: false
    }
}


----
Вы можете использовать Stream API для проверки строки на палиндром с исключением не-букв. Вот как это можно сделать:

```java
import java.util.stream.IntStream;

public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return IntStream.range(0, cleanStr.length() / 2)
            .allMatch(i -> cleanStr.charAt(i) == cleanStr.charAt(cleanStr.length() - i - 1));
    }
    
    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal, Panama!";
        String str2 = "Hello, world!";
        
        System.out.println(isPalindrome(str1)); // Вывод: true
        System.out.println(isPalindrome(str2)); // Вывод: false
    }
}
```

В этом примере, `IntStream.range(0, cleanStr.length() / 2)` создает поток индексов от 0 до половины длины строки. Метод `allMatch` проверяет, что все символы с соответствующими индексами с начала и с конца строки совпадают. Если хотя бы одна пара символов не совпадает, метод вернет `false`, что означает, что строка не является палиндромом.

###


###
