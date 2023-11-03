package threads.conccurent2.countdownlatch;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Buyer extends Thread{
    private long id;
    private int currentPrice;
    private int cashAmount;

    private CyclicBarrier barrier = Auction.barrier;

    public Buyer(long id, int currentPrice, int cashAmount) {
        this.id = id;
        this.currentPrice = currentPrice;
        this.cashAmount = cashAmount;
    }


    public long getId() {
        return id;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public int getCashAmount() {
        return cashAmount;
    }



    public void setCashAmount(int cashAmount) {
        this.cashAmount = cashAmount;
    }

    @Override
    public void run() {
        try {
            System.out.println(id + " : " + cashAmount);
            Thread.sleep(new Random().nextInt(2000));
            int d = new Random().nextInt(10);
            System.out.println(id + " : " + currentPrice);
            this.barrier.await();
            System.out.println(id + " continue...");
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
