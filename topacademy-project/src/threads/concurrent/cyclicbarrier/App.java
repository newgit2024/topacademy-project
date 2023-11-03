package threads.concurrent.cyclicbarrier;

import threads.concurrent.CsvProcessor;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class App {
    public static void main(String[] args) {
        CsvProcessor processor = new CsvProcessor("input.csv");
        Scanner scanner = new Scanner(System.in);
        int wordCount = scanner.nextInt();
        scanner.nextLine();

        List<Long> results = new CopyOnWriteArrayList<>();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(wordCount, () -> System.out.println(results));

        String word = scanner.nextLine();
        int i = 0;
        while (i < wordCount) {
            final String wordForTask = word;
            Runnable task = () -> {
                long result = processor.countByPosition(4, wordForTask);
                results.add(result);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(result);
            };
            new Thread(task, word).start();
            i++;
            word = scanner.nextLine();
        }
    }
}
