```java
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class sumService {

    @Value
    Map<String, Integer> taxes = new HashMap();

    public BigDecimal sum(BigDecimal number, tax tax) {
        Map<String, Integer> taxes = new HashMap();
        if (number == 0) return 0;
        if (number < 0) throw new IllegalArgumentException("Отрицательная сумма");

        return number - number / 100 * tax.get();
    }
}

class

enum tax {
    RU(13),
    DE(19)
}

@Configuration
@ConfigurationPrefix("taxe")
class Taxes {

}

yml
        De->19
        RU->13
```
###
Вам даны две строки word1 и word2. Объедините строки, добавляя буквы в чередующемся порядке, начиная со слова 1.
Если одна строка длиннее другой, добавьте дополнительные буквы в конец объединенной строки.

Возвращает объединенную строку.

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Example 2:
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s

Example 3:
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d


class Solution {
public String mergeAlternately(String word1, String word2) {


	}
}



```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int i = 0;
        
        while (i < word1.length() && i < word2.length()) {
            merged.append(word1.charAt(i)).append(word2.charAt(i));
            i++;
        }
        
        if (i < word1.length()) {
            merged.append(word1.substring(i));
        }
        
        if (i < word2.length()) {
            merged.append(word2.substring(i));
        }
        
        return merged.toString();
    }
}

```



###
// В предложенном классе дублирование кода в firstMethod и secondMethod. Проведите рефакторинг, сохранив сигнатуру методов firstMethod и secondMethod.

public class RefactoringTest {

    public void firstMethod() {
        System.out.println("one");
        System.out.println("two");
        RefCreator.printOne();
        System.out.println("three");
    }

    public void secondMethod() {
        System.out.println("one");
        System.out.println("two");
        RefCreator.printTwo();
        System.out.println("three");
    }
    
  
    static class Creator {
        static void printOne() {
            System.out.println("printOne");
        }

        static void printTwo() {
            System.out.println("printTwo");
        }
    }

    public static void main(String[] args) {
        RefactoringTest refactoringTest = new RefactoringTest();
        refactoringTest.firstMethod();
        refactoringTest.secondMethod();
    }
}

```java
//Чтобы избавиться от дублирования кода в методах `firstMethod` и `secondMethod`, можно использовать лямбда-выражение для передачи метода `RefCreator.printOne` или `RefCreator.printTwo` в параметры методов. Вот как это можно сделать:


public class RefactoringTest {

    public void processMethod(Runnable action) {
        System.out.println("one");
        System.out.println("two");
        action.run();
        System.out.println("three");
    }

    public void firstMethod() {
        processMethod(RefCreator::printOne);
    }

    public void secondMethod() {
        processMethod(RefCreator::printTwo);
    }
  
    static class RefCreator {
        static void printOne() {
            System.out.println("printOne");
        }

        static void printTwo() {
            System.out.println("printTwo");
        }
    }

    public static void main(String[] args) {
        RefactoringTest refactoringTest = new RefactoringTest();
        refactoringTest.firstMethod();
        refactoringTest.secondMethod();
    }
}

//Таким образом, метод `processMethod` принимает в качестве параметра объект типа `Runnable`, который представляет собой действие, которое нужно выполнить. Вызовы `RefCreator::printOne` и `RefCreator::printTwo` преобразуются в лямбда-выражения, которые передаются в методы `firstMethod` и `secondMethod`. Это позволяет избежать дублирования кода в методах, сохраняя сигнатуры методов без изменений.
```


###
--Определить товары, которые покупали более 1 раза по четырем таблицам Paiments, FamilyMembers, GoodTypes, Goods

```sql
SELECT Goods.name
FROM Paiments
INNER JOIN FamilyMembers ON Paiments.family_member_id = FamilyMembers.id
INNER JOIN GoodTypes ON Paiments.good_type_id = GoodTypes.id
INNER JOIN Goods ON Paiments.good_id = Goods.id
GROUP BY Goods.name
HAVING COUNT(*) > 1;
```