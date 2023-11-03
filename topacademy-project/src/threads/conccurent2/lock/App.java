package threads.conccurent2.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

public class App {
    public static void main(String[] args) {
        Deposit deposit = new Deposit();
        new Thread(()->deposit.output()).start();
        try {
            sleep(150);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        deposit.input();
        System.out.println("finish");

        //ReentrantReadWriteLock
    }
}
