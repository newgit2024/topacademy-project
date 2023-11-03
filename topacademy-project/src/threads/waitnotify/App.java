package threads.waitnotify;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        scanner.nextLine();
        Product product = new Product();
        Producer producer = new Producer(product);
        Consumer consumer = new Consumer(product);

        producer.start();
        consumer.start();
    }
}
