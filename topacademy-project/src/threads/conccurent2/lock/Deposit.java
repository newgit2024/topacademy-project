package threads.conccurent2.lock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Deposit {
    private int cash;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    public void output() {
        try {
            lock.lock();  // block until condition holds
            // ... method body
            while (cash <= 0){
                condition.await();
            }
            cash -= 1;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void input(){
        try{
            lock.lock();
            System.out.println("Amount: ");
            cash = new Scanner(System.in).nextInt();
        } finally {
            condition.signal();
            lock.unlock();
        }
    }
}
