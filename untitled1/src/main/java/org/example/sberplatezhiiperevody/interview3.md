##
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceWithCallback {
public static void main(String[] args) {
ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Отправляем задачу на выполнение и получаем Future объект
        Future<Integer> future = executorService.submit(() -> {
            // Выполняем задачу
            Thread.sleep(1000);
            return 42; // Возвращаем результат
        });

        // Выполняем обратный вызов по завершению задачи
        futureCallback(future);

        // Завершаем работу ExecutorService после выполнения всех задач
        executorService.shutdown();
    }

    private static void futureCallback(Future<Integer> future) {
        // Планируем выполнение колбэка после завершения задачи
        executorService.submit(() -> {
            try {
                int result = future.get(); // Получаем результат задачи
                System.out.println("Callback: Task completed with result: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
```


##
