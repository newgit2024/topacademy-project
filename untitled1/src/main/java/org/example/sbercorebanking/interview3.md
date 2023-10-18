##
Давайте создадим пример кода, который использует `ExecutorService` для выполнения задач в пуле потоков. В этом примере будет создан пул из 4 потоков, и мы отправим 10 задач на выполнение:

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        // Создаем ExecutorService с пулом из 4 потоков
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 1; i <= 10; i++) {
            final int taskNumber = i;
            // Отправляем задачу на выполнение
            executorService.submit(() -> {
                System.out.println("Task " + taskNumber + " is being executed by thread: " + Thread.currentThread().getName());
                // Имитируем выполнение задачи
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskNumber + " completed by thread: " + Thread.currentThread().getName());
            });
        }

        // Завершаем работу ExecutorService после выполнения всех задач
        executorService.shutdown();
    }
}
```

В этом примере мы создаем `ExecutorService` с пулом из 4 потоков, отправляем 10 задач на выполнение, и `ExecutorService` автоматически распределяет их между доступными потоками. Каждая задача выполняется асинхронно в одном из потоков пула.

После выполнения всех задач, мы вызываем `executorService.shutdown()`, чтобы завершить работу пула потоков.


##
