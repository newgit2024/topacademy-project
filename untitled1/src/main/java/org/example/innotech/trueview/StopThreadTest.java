package org.example.innotech.trueview;

import java.util.concurrent.TimeUnit;

public class StopThreadTest {
    private static
    // 1. volatile 2. AtomicBoolean
    boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
                //doMonitoring(); -> backgroundThread.setDaemon();
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}


//`ReentrantLock` (переводится как "реентерабельная блокировка") - это класс в Java из пакета `java.util.concurrent.locks`, предоставляющий более гибкий и расширенный механизм блокировки, чем синхронизация с помощью ключевого слова `synchronized`. Этот класс представляет собой "замок", который может быть захвачен и освобожден потоками, обеспечивая контроль доступа к критическим секциям кода.
//
//Основные особенности `ReentrantLock`:
//
//1. **Реентерабельность**: Этот замок поддерживает реентерабельность, что означает, что поток, который уже захватил замок, может повторно его захватить без блокировки. Это удобно, когда один метод вызывает другой метод, который также требует той же блокировки.
//
//2. **Поддержка условий**: `ReentrantLock` поддерживает создание условий, которые позволяют потокам ожидать определенных условий выполнения. Это особенно полезно для управления порядком выполнения потоков.
//
//3. **Попытка блокировки с таймаутом**: Методы `tryLock()` позволяют попытаться захватить замок с указанным таймаутом. Это позволяет избежать бесконечного ожидания замка.
//
//4. **Интерруптируемость**: Метод `lockInterruptibly()` позволяет потокам прервать ожидание блокировки при получении сигнала о прерывании.
//
//Пример использования `ReentrantLock`:
//
//```java
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class Main {
//    public static void main(String[] args) {
//        Lock lock = new ReentrantLock();
//
//        // Вход в блокировку
//        lock.lock();
//        try {
//            // Критическая секция
//        } finally {
//            // Выход из блокировки
//            lock.unlock();
//        }
//    }
//}
//```
//
//`ReentrantLock` предоставляет более точный контроль над блокировками, позволяя более гибко управлять синхронизацией в многопоточных приложениях. Однако следует быть внимательным при использовании этого механизма, чтобы избежать возможных проблем, таких как дедлоки (зацикливание блокировок).

