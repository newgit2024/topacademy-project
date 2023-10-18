###

Оценка временной сложности алгоритма позволяет определить, как быстро растет время выполнения алгоритма с увеличением
размера входных данных. Временная сложность обозначается как "O(f(n))", где "f(n)" - это функция, описывающая рост
времени выполнения алгоритма относительно размера входных данных "n".

Вот несколько примеров алгоритмов и оценок их временной сложности:

1. Константное время O(1):
   Пример: Получение элемента по индексу из массива.
   ```java
   int getElement(int[] array, int index) {
       return array[index];
   }
   ```

2. Линейное время O(n):
   Пример: Поиск элемента в несортированном массиве.
   ```java
   boolean contains(int[] array, int element) {
       for (int num : array) {
           if (num == element) {
               return true;
           }
       }
       return false;
   }
   ```

3. Квадратичное время O(n^2):
   Пример: Сортировка выбором (Selection Sort).
   ```java
   void selectionSort(int[] array) {
       int n = array.length;
       for (int i = 0; i < n - 1; i++) {
           int minIndex = i;
           for (int j = i + 1; j < n; j++) {
               if (array[j] < array[minIndex]) {
                   minIndex = j;
               }
           }
           int temp = array[i];
           array[i] = array[minIndex];
           array[minIndex] = temp;
       }
   }
   ```

4. Логарифмическое время O(log n):
   Пример: Бинарный поиск в отсортированном массиве.
   ```java
   int binarySearch(int[] array, int target) {
       int left = 0;
       int right = array.length - 1;
       while (left <= right) {
           int mid = left + (right - left) / 2;
           if (array[mid] == target) {
               return mid;
           } else if (array[mid] < target) {
               left = mid + 1;
           } else {
               right = mid - 1;
           }
       }
       return -1;
   }
   ```

5. Полиномиальное время O(n^k):
   Пример: Умножение матриц.
   ```java
   int[][] matrixMultiply(int[][] A, int[][] B) {
       int n = A.length;
       int m = A[0].length;
       int p = B[0].length;
       int[][] C = new int[n][p];
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < p; j++) {
               for (int k = 0; k < m; k++) {
                   C[i][j] += A[i][k] * B[k][j];
               }
           }
       }
       return C;
   }
   ```

Оценка временной сложности позволяет определить, насколько эффективен алгоритм для обработки больших объемов данных. Чем
меньше степень роста функции "f(n)", тем более эффективен алгоритм при работе с большими наборами данных.

###

1. Пример с временной сложностью O(n log n):
   Сортировка слиянием (Merge Sort).
   ```java
   void mergeSort(int[] array, int left, int right) {
       if (left < right) {
           int mid = (left + right) / 2;
           mergeSort(array, left, mid);
           mergeSort(array, mid + 1, right);
           merge(array, left, mid, right);
       }
   }
   
   void merge(int[] array, int left, int mid, int right) {
       int n1 = mid - left + 1;
       int n2 = right - mid;
       int[] leftArr = new int[n1];
       int[] rightArr = new int[n2];
   
       for (int i = 0; i < n1; i++) {
           leftArr[i] = array[left + i];
       }
       for (int j = 0; j < n2; j++) {
           rightArr[j] = array[mid + 1 + j];
       }
   
       int i = 0, j = 0, k = left;
       while (i < n1 && j < n2) {
           if (leftArr[i] <= rightArr[j]) {
               array[k] = leftArr[i];
               i++;
           } else {
               array[k] = rightArr[j];
               j++;
           }
           k++;
       }
   
       while (i < n1) {
           array[k] = leftArr[i];
           i++;
           k++;
       }
   
       while (j < n2) {
           array[k] = rightArr[j];
           j++;
           k++;
       }
   }
   ```

2. Пример с временной сложностью O(n!):
   Рекурсивный перебор всех перестановок массива.
   ```java
   void permute(int[] array, int start, int end) {
       if (start == end) {
           // Обработка одной перестановки массива
           for (int i : array) {
               System.out.print(i + " ");
           }
           System.out.println();
       } else {
           for (int i = start; i <= end; i++) {
               swap(array, start, i);
               permute(array, start + 1, end);
               swap(array, start, i); // Возвращение массива в исходное состояние
           }
       }
   }
   
   void swap(int[] array, int i, int j) {
       int temp = array[i];
       array[i] = array[j];
       array[j] = temp;
   }
   ```

Важно отметить, что алгоритмы с временной сложностью O(n log n) являются гораздо более эффективными, чем алгоритмы с
временной сложностью O(n!), особенно при работе с большими наборами данных. Перебор всех перестановок имеет
экспоненциальное время выполнения и будет неэффективным для массивов с большим количеством элементов.

####

Временная сложность структур данных может быть различной в зависимости от операций, которые выполняются над данными. В
таблице ниже представлены типичные операции для различных структур данных и их ожидаемые временные сложности в Java:

| Структура данных                            | Вставка (Insert)                        | Удаление (Delete)                       | Поиск (Search)                               | Получение элемента (Get) |
|---------------------------------------------|-----------------------------------------|-----------------------------------------|----------------------------------------------|--------------------------|
| Массив (Array)                              | O(n)                                    | O(n)                                    | O(n)                                         | O(1)                     |
| Связный список (LinkedList)                 | O(1) (в начало/конец) O(n) (в середину) | O(1) (в начале/конец) O(n) (в середине) | O(n)                                         | O(n)                     |
| Стек (Stack)                                | O(1)                                    | O(1)                                    | O(n)                                         | O(n)                     |
| Очередь (Queue)                             | O(1)                                    | O(1)                                    | O(n)                                         | O(n)                     |
| Двоичное дерево поиска (Binary Search Tree) | O(log n)                                | O(log n)                                | O(log n)                                     | O(log n)                 |
| Красно-черное дерево (Red-Black Tree)       | O(log n)                                | O(log n)                                | O(log n)                                     | O(log n)                 |
| Хеш-таблица (Hash Table)                    | O(1)                                    | O(1)                                    | O(1)                                         | O(1)                     |
| Куча (Heap)                                 | O(log n)                                | O(log n)                                | O(n)                                         | O(1)                     |
| Граф (Graph)                                | O(1) (при хорошей реализации)           | O(1) (при хорошей реализации)           | O(n) (поиск в ширину) O(E) (поиск в глубину) | O(1)                     |

Здесь:

- n - количество элементов в структуре данных.
- E - количество ребер в графе.
- O(1) - постоянное время (константная сложность).
- O(log n) - логарифмическое время.
- O(n) - линейное время.
- O(n log n) - линейно-логарифмическое время.
- O(n!) - факториальное время (крайне неэффективно).

Важно помнить, что оценка временной сложности зависит от реализации и конкретных операций, поэтому эти значения могут
меняться в различных ситуациях. Кроме того, амортизированная сложность также может учитываться при анализе реальной
производительности структур данных.

###

Ниже представлена таблица с временными сложностями некоторых структур данных и алгоритмов в худшем, среднем и лучшем
случаях:

| Структура данных / Алгоритм                 | Худший случай | Средний случай | Лучший случай |
|---------------------------------------------|---------------|----------------|---------------|
| Массив (Array)                              | O(n)          | O(n)           | O(1)          |
| Связный список (Linked List)                | O(n)          | O(n)           | O(1)          |
| Двоичное дерево поиска (Binary Search Tree) | O(n)          | O(log n)       | O(log n)      |
| Хеш-таблица (Hash Table)                    | O(n)          | O(1)           | O(1)          |
| Сортировка слиянием (Merge Sort)            | O(n log n)    | O(n log n)     | O(n log n)    |
| Быстрая сортировка (Quick Sort)             | O(n^2)        | O(n log n)     | O(n log n)    |
| Поиск в графе (BFS / DFS)                   | O(V + E)      | O(V + E)       | O(V + E)      |
| Поиск в хеш-таблице                         | O(n)          | O(1)           | O(1)          |

Здесь:

- n - количество элементов в структуре данных или размер массива.
- V - количество вершин в графе.
- E - количество ребер в графе.
- O(1) - константное время (постоянная сложность).
- O(log n) - логарифмическое время.
- O(n) - линейное время.
- O(n log n) - линейно-логарифмическое время.
- O(n^2) - квадратичное время.

Заметим, что время выполнения операций может изменяться в зависимости от различных факторов и реализаций алгоритмов.
Поэтому эта таблица представляет общее представление о временных сложностях, но не учитывает все возможные варианты.

###

Алгоритм с временной сложностью O(2^n) - это алгоритм с экспоненциальной сложностью, который растет очень быстро с
увеличением размера входных данных. Такой алгоритм обычно считается неэффективным и не рекомендуется для больших объемов
данных. Один из примеров такого алгоритма - это рекурсивное вычисление чисел Фибоначчи без использования динамического
программирования.

Пример рекурсивного алгоритма для вычисления чисел Фибоначчи с O(2^n):

```java
public class Fibonacci {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
```

В данном примере функция `fibonacci(n)` рекурсивно вызывает саму себя для вычисления чисел Фибоначчи. Каждый раз при
вызове функции она делает два рекурсивных вызова для чисел `n-1` и `n-2`. В результате, время выполнения алгоритма
растет экспоненциально с ростом `n`. Например, для `n=10`, алгоритм выполнится около 109-10 раз, что может занять
значительное время.

Для больших значений `n`, алгоритм становится очень медленным и может вызывать переполнение стека из-за большого числа
рекурсивных вызовов.