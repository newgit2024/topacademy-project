package threads.concurrent.countdownlatch;

import threads.concurrent.CsvProcessor;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class App {
    public static void main(String[] args) {
        CsvProcessor processor = new CsvProcessor("input.csv");
        Scanner scanner = new Scanner(System.in);
        int wordCount = scanner.nextInt();
        scanner.nextLine();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        String word = scanner.nextLine();
        int i = 0;
        while (i < wordCount) {
            final String wordForTask = word;
            Runnable task = () -> {
                countDownLatch.countDown();
                try {
                    System.out.println("Task for finding... " + wordForTask + "was got -> go to waiting");
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task for " + wordForTask + " is running...");
                System.out.println(processor.countByPosition(4, wordForTask));
            };
            new Thread(task, word).start();
            i++;
            word = scanner.nextLine();
        }
    }
}
