package threads.basic;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        Thread egg = new Egg();
        Thread chicken = new Chicken();

        egg.start();
        chicken.start();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 100_000; i++){
            System.out.println("Kapibara");
        }
    }
}
