###
В этом рефакторинге мы импортируем все классы из пакета, чтобы не указывать каждый класс отдельно. Затем мы добавляем модификатор доступа "public" к классу Optional Task. Мы также добавляем константу NO-" Not found", чтобы использовать ее в случае, если книга не будет найдена. Мы изменяем имя метода на "findBook" и добавляем тип возвращаемого значения "String". Мы также добавляем аргумент "int price" для указания цены, по которой мы хотим найти книгу. Внутри метода мы используем стрим для фильтрации списка книг по цене и находим первую книгу, удовлетворяющую условию. Если такая книга найдена, мы возвращаем ее имя. В противном случае, мы возвращаем строку "Not found".
```java
import java.util.*;
import java.util.stream.Collectors;

public class OptionalTask {
public static final String NOT_FOUND = "Not found";

    public String findBook(List<Book> books, int price) {
        Optional<Book> optionalBook = books.stream()
                .filter(book -> book.getPrice() == price)
                .findFirst();

        return optionalBook.map(Book::getName).orElse(NOT_FOUND);
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book1", 10));
        books.add(new Book("Book2", 20));
        books.add(new Book("Book3", 30));

        OptionalTask task = new OptionalTask();
        System.out.println(task.findBook(books, 20)); // Output: Book2
        System.out.println(task.findBook(books, 40)); // Output: Not found
    }
}

class Book {
private String name;
private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
```

```java
import java.util.*;
import java.util.stream.Collectors;

public class OptionalTask {
public static final String NOT_FOUND = "Not found";

    public String findBook(List<Book> books, int price) {
        Optional<Book> cheaperBook = books.stream()
                .filter(book -> book.getPrice() < price)
                .findFirst();

        if (cheaperBook.isPresent()) {
            return cheaperBook.get().getName();
        } else {
            return NOT_FOUND;
        }
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book1", 10));
        books.add(new Book("Book2", 20));
        books.add(new Book("Book3", 30));

        OptionalTask task = new OptionalTask();
        System.out.println(task.findBook(books, 20)); // Output: Book1
        System.out.println(task.findBook(books, 40)); // Output: Not found
    }
}

class Book {
private String name;
private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
```


###
Конечно, вот код с правильными отступами:

```java
import java.util.*;
import java.util.stream.*;

public class StreamOperationsUseCases {
    public static void main(String[] args) {
        streamUseCase_OddsEvens();
        System.out.println(streamUseCase2_Songs());
        streamUseCase3_Average();
    }

    private static void streamUseCase_OddsEvens() {
        Random randomizer = new Random();
        Stream<Integer> stream = randomizer.ints().boxed().limit(50);
        // ЗАДАНИЕ:
        // Нужно разделить числа в стриме на чётные и нечётные,
        // но таким образом, чтобы иметь возможность после этого
        // работать с обоими множествами
    }

    private static List<String> streamUseCase2_Songs() {
        List<String> songs = Arrays.asList("Song1", "...Song2...", "Song3", "...Song4...");
        return songs.stream()
                .filter(song -> !isFakeSong(song))
                .collect(Collectors.toList());
    }

    private static boolean isFakeSong(String song) {
        return song.startsWith("...") && song.endsWith("...");
    }

    private static void streamUseCase3_Average() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("Average: " + average);
    }
}
```

Теперь код выглядит более читаемо и оформлено с правильными отступами.

Код, который вы предоставили, имеет синтаксические ошибки и не полностью четко оформлен. Я произвел некоторые коррекции и форматирование, чтобы код выглядел более читаемо:

```java
import java.util.*;
import java.util.stream.*;

public class StreamOperationsUseCases {
    public static void main(String[] args) {
        streamUseCase_OddsEvens();
        System.out.println(streamUseCase2_Songs());
        streamUseCase3_Average();
    }

    private static void streamUseCase_OddsEvens() {
        Random randomizer = new Random();
        List<Integer> numbers = randomizer.ints().limit(50).boxed().collect(Collectors.toList());

        Map<Boolean, List<Integer>> oddAndEvenMap = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        List<Integer> evenNumbers = oddAndEvenMap.get(true);
        List<Integer> oddNumbers = oddAndEvenMap.get(false);

        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
    }

    private static List<String> streamUseCase2_Songs() {
        List<String> songs = Arrays.asList("Song1", "...Song2...", "Song3", "...Song4...");
        return songs.stream()
                .filter(song -> !isFakeSong(song))
                .collect(Collectors.toList());
    }

    private static boolean isFakeSong(String song) {
        return song.startsWith("...") && song.endsWith("...");
    }

    private static void streamUseCase3_Average() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("Average: " + average);
    }
}
```

Здесь я внес исправления, чтобы код был синтаксически корректным и структурированным. Однако для методов `streamUseCase2_Songs()` и `streamUseCase3_Average()` не предоставлены их реализации. Вы должны дополнить эти методы соответствующей логикой в соответствии с вашими задачами.
###
`Lock` и `ReentrantLock` - это механизмы синхронизации в Java, которые позволяют контролировать доступ к общим ресурсам из нескольких потоков.

Пример использования `ReentrantLock`:

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private static int count = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + count);
    }

    private static void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
```

Плюсы `Lock` и `ReentrantLock`:
1. Гибкость: позволяют более точно управлять блокировками, например, устанавливать таймаут, использовать условия для ожидания, и т.д.
2. Возможность прервать ожидающие потоки с помощью метода `interrupt`.
3. Поддержка механизма "справедливости", когда блокировка предоставляется потокам в порядке их запросов.

Минусы:
1. Больше кода: использование `Lock` требует больше кода по сравнению с `synchronized`.
2. Возможность забыть вызвать `unlock`, что может привести к блокировке всего приложения.
3. Сложнее для понимания и использования для начинающих программистов.

Важно помнить, что `ReentrantLock` следует использовать тогда, когда `synchronized` не предоставляет достаточной гибкости или производительности, либо когда требуется более сложная логика синхронизации.

###
`ReadWriteLock` предоставляет механизм для синхронизации доступа к общим данным между потоками, разделяя доступ на две категории: чтение (read) и запись (write). Это позволяет разрешить одновременное чтение данных несколькими потоками, но только одному потоку разрешается запись.

Пример использования `ReadWriteLock`:

```java
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private static int data = 0;
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        Runnable readTask = () -> {
            readData();
        };

        Runnable writeTask = () -> {
            writeData(5);
        };

        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);
        Thread writeThread = new Thread(writeTask);

        readThread1.start();
        readThread2.start();
        writeThread.start();

        try {
            readThread1.join();
            readThread2.join();
            writeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void readData() {
        readWriteLock.readLock().lock();
        try {
            System.out.println("Reading data: " + data);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    private static void writeData(int newValue) {
        readWriteLock.writeLock().lock();
        try {
            data = newValue;
            System.out.println("Writing data: " + data);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
```

Плюсы `ReadWriteLock`:
1. Позволяет одновременно выполнять чтение данными несколькими потоками.
2. Повышает производительность в случае, если доступ на чтение используется чаще, чем доступ на запись.

Минусы:
1. Сложнее для понимания и использования, чем обычные блокировки.
2. В некоторых случаях может привести к "голоданию" записи, когда потоки, ожидающие чтения, могут заблокировать запись на долгое время.

`ReadWriteLock` следует использовать тогда, когда есть большое количество операций чтения данных и они не изменяют состояние, в то время как запись данных выполняется реже.


###
`ReadWriteLock` предоставляет механизм для синхронизации доступа к общим данным между потоками, разделяя доступ на две категории: чтение (read) и запись (write). Это позволяет разрешить одновременное чтение данных несколькими потоками, но только одному потоку разрешается запись.

Пример использования `ReadWriteLock`:

```java
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private static int data = 0;
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        Runnable readTask = () -> {
            readData();
        };

        Runnable writeTask = () -> {
            writeData(5);
        };

        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);
        Thread writeThread = new Thread(writeTask);

        readThread1.start();
        readThread2.start();
        writeThread.start();

        try {
            readThread1.join();
            readThread2.join();
            writeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void readData() {
        readWriteLock.readLock().lock();
        try {
            System.out.println("Reading data: " + data);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    private static void writeData(int newValue) {
        readWriteLock.writeLock().lock();
        try {
            data = newValue;
            System.out.println("Writing data: " + data);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
```

Плюсы `ReadWriteLock`:
1. Позволяет одновременно выполнять чтение данными несколькими потоками.
2. Повышает производительность в случае, если доступ на чтение используется чаще, чем доступ на запись.

Минусы:
1. Сложнее для понимания и использования, чем обычные блокировки.
2. В некоторых случаях может привести к "голоданию" записи, когда потоки, ожидающие чтения, могут заблокировать запись на долгое время.

`ReadWriteLock` следует использовать тогда, когда есть большое количество операций чтения данных и они не изменяют состояние, в то время как запись данных выполняется реже.

###
Пулы потоков (ThreadPool) - это механизмы, предназначенные для управления и переиспользования потоков в многопоточных приложениях. Они позволяют снизить накладные расходы на создание и завершение потоков, обеспечивая более эффективное использование ресурсов.

Существует несколько видов пулов потоков, каждый из которых предоставляет разные стратегии управления потоками. Вот некоторые из наиболее распространенных видов пулов потоков:

1. **FixedThreadPool (Фиксированный пул потоков):** Этот вид пула представляет собой пул с фиксированным числом потоков. Количество потоков в пуле задается заранее и не изменяется. Если все потоки заняты выполнением задач, новые задачи ставятся в очередь и ожидают выполнения.

2. **CachedThreadPool (Пул потоков с динамическим числом):** Этот пул позволяет создавать потоки по мере необходимости и переиспользовать их. Если в пуле есть свободный поток, задача будет передана ему. Если нет свободных потоков, создается новый. Если поток не используется в течение некоторого времени, он может быть завершен и удален из пула.

3. **SingleThreadExecutor (Однопоточный исполнитель):** Этот пул содержит только один поток. Все задачи поочередно передаются этому потоку на выполнение. Он полезен, когда нужно гарантировать, что задачи выполняются последовательно.

4. **ScheduledThreadPool (Пул планировщика):** Этот пул предоставляет планировщик для выполнения задач в определенное время или через определенные промежутки времени. Он используется для периодического выполнения задач, например, запуска задач по расписанию.

Каждый вид пула потоков имеет свои плюсы и минусы:

Плюсы:
- Повышает производительность и эффективность, уменьшая накладные расходы на создание и завершение потоков.
- Позволяет контролировать количество одновременно выполняющихся задач и избегать перегрузки системы.

Минусы:
- Недостаточное количество потоков может привести к задержкам выполнения задач.
- Слишком большое количество потоков может потребовать больше ресурсов и увеличить накладные расходы на управление потоками.

Выбор подходящего типа пула потоков зависит от конкретных требований приложения и характера задач, которые необходимо выполнить.

###
В Java есть следующие типы ссылок:

1. **Strong Reference (Сильная ссылка):** Это стандартный тип ссылки, который мы часто используем в коде. Как только на объект есть хотя бы одна сильная ссылка, объект остается в памяти, и сборщик мусора не может освободить его.

2. **Soft Reference (Мягкая ссылка):** Мягкие ссылки используются для объектов, которые могут быть удалены из памяти только если системе не хватает памяти. Когда JVM начинает испытывать нехватку памяти, объекты, на которые есть мягкие ссылки, будут удалены, чтобы освободить память. Они часто используются для кэширования.

3. **Weak Reference (Слабая ссылка):** Слабые ссылки используются для объектов, которые могут быть удалены из памяти при следующем проходе сборщика мусора, даже если памяти достаточно. Слабые ссылки обычно используются для реализации слабых коллекций.

4. **Phantom Reference (Фантомная ссылка):** Фантомные ссылки используются для объектов, которые скоро будут удалены сборщиком мусора. Они не могут быть использованы для получения объекта напрямую. Их главное предназначение - следить за процессом удаления объектов и выполнять какие-либо действия при удалении.

Сборщик мусора автоматически удаляет объекты, на которые нет сильных ссылок. В случае мягких ссылок, сборщик мусора удалит объекты, на которые есть только мягкие ссылки, если система испытывает нехватку памяти. Слабые ссылки могут быть удалены в любой момент, когда сборщик мусора обнаруживает их. Фантомные ссылки требуют особой обработки через ReferenceQueue и позволяют выполнить некоторые действия перед окончательным удалением объекта.

Принципы удаления ссылок в Java следующие:
- Сильные ссылки удаляются, когда на объект нет больше сильных ссылок.
- Мягкие ссылки удаляются, когда системе не хватает памяти.
- Слабые ссылки могут быть удалены в любой момент сборщиком мусора.
- Фантомные ссылки могут быть удалены после того, как объект станет недостижимым, но перед окончательным удалением можно выполнить определенные действия.
###
CMS (Concurrent Mark-Sweep) и G1 (Garbage-First) - это два различных сборщика мусора в Java Virtual Machine (JVM), предназначенные для управления памятью и сборки мусора. Оба сборщика мусора имеют свои плюсы и минусы, и выбор между ними зависит от конкретных требований приложения.

Вот некоторые плюсы и минусы CMS и G1 в сравнении:

**CMS (Concurrent Mark-Sweep):**
Плюсы:
- Проводит сборку мусора во время паузы в приложении (concurrent) для большей отзывчивости.
- Хорошо подходит для приложений с большим количеством потоков и большой памятью.
- Стремится к минимизации пауз сборки мусора.

Минусы:
- Может привести к фрагментации памяти, что в конечном итоге может вызвать фрагментацию кучи и ухудшение производительности.
- Имеет паузы старта и завершения сборки мусора, что может быть проблемой для реактивных приложений.

**G1 (Garbage-First):**
Плюсы:
- Проектирован для уменьшения паузы сборки мусора, путем разбиения памяти на регионы и сборки мусора только в некоторых регионах.
- Подходит для больших приложений с большими объемами памяти и высокой степенью фрагментации.
- Минимизирует паузы сборки мусора.

Минусы:
- Может иметь некоторую накладную плату на производительность из-за управления регионами и дополнительных структур данных.
- В редких случаях может иметь длительные паузы, особенно при недостаточной памяти или высокой нагрузке.

Оба сборщика мусора имеют свои особенности и оптимизированы для разных сценариев использования. Если у вас большое приложение с большими объемами памяти, G1 может быть хорошим выбором, чтобы минимизировать паузы сборки мусора. Если вы хотите более низкую латентность для приложения с большим числом потоков, то CMS может быть предпочтительнее. Важно провести тестирование и анализ нагрузки, чтобы определить наилучший сборщик мусора для вашего конкретного приложения.
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###