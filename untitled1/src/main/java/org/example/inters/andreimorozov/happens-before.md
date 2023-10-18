Принцип happens-before (HB) является одним из ключевых понятий в Java Memory Model (JMM) и определяет отношение порядка между операциями в многопоточной среде. Если одна операция happens-before другую, то гарантируется, что результаты первой операции видны второй операции, то есть изменения, сделанные одним потоком, будут видны другим потокам в правильном порядке. Ниже приведены примеры кода, иллюстрирующие все четыре правила happens-before:

1. Правило запуска потока:

```java
public class HappensBeforeExample1 {
    static int x = 0;

    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            x = 42; // Запись в общую переменную
        });

        Thread readerThread = new Thread(() -> {
            if (x == 42) { // Чтение общей переменной
                System.out.println("Value of x: " + x);
            }
        });

        writerThread.start();
        readerThread.start();
    }
}
```

Здесь операция записи в переменную `x` 
в потоке `writerThread` happens-before операцию чтения переменной `x` 
в потоке `readerThread`. 
Таким образом, результат записи `42` будет виден при чтении переменной `x` 
во втором потоке.

2. Правило завершения потока:

```java
public class HappensBeforeExample2 {
    static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread writerThread = new Thread(() -> {
            x = 42; // Запись в общую переменную
        });

        Thread readerThread = new Thread(() -> {
            while (x == 0) {
                // Ожидание завершения записи
            }
            System.out.println("Value of x: " + x);
        });

        writerThread.start();
        readerThread.start();

        writerThread.join();
        readerThread.join();
    }
}
```

Здесь завершение потока `writerThread` happens-before начало выполнения 
операции чтения переменной `x` в потоке `readerThread`. 
Таким образом, результат записи `42` будет виден при чтении переменной `x` 
во втором потоке.

3. Правило блокировок (monitor lock):

```java
public class HappensBeforeExample3 {
    static int x = 0;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            synchronized (lock) {
                x = 42; // Запись в общую переменную
            }
        });

        Thread readerThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Value of x: " + x); // Чтение общей переменной
            }
        });

        writerThread.start();
        readerThread.start();
    }
}
```

Здесь операция записи `x = 42` в потоке `writerThread` happens-before операцию чтения `System.out.println("Value of x: " + x)` в потоке `readerThread`, так как обе операции происходят внутри синхронизированного блока с использованием одного и того же монитора.

4. Правило volatile:

```java
public class HappensBeforeExample4 {
    static volatile int x = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread writerThread = new Thread(() -> {
            x = 42; // Запись в общую volatile переменную
        });

        Thread readerThread = new Thread(() -> {
            if (x == 42) { // Чтение общей volatile переменной
                System.out.println("Value of x: " + x);
            }
        });

        writerThread.start();
        readerThread.start();

        writerThread.join();
        readerThread.join();
    }
}
```

Здесь операция записи `x = 42` в потоке `writerThread` happens-before операцию чтения `System.out.println("Value of x: " + x)` в потоке `readerThread`, так как `x` объявлена как `volatile`. Это гарантирует, что все потоки видят актуальное значение `x`.

Это были примеры, иллюстрирующие каждое правило happens-before. Используйте эти принципы для проектирования и разработки безопасных и корректных многопоточных программ.