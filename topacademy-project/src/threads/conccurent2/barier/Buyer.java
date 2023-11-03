package threads.conccurent2.barier;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Buyer extends Thread{
    private long id;
    private int currentPrice;
    private int cashAmount;
    private CountDownLatch latchEnd = Auction.auctionLatch;
    private CountDownLatch latchBegin = Auction.auctionLatchBegin;
    private boolean lost;

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

    public boolean isLost() {
        return lost;
    }

    public void setCashAmount(int cashAmount) {
        this.cashAmount = cashAmount;
    }

    @Override
    public void run() {
        try {
            if (cashAmount < currentPrice) {
                lost = true;
                latchBegin.countDown();
                System.out.println("Buyer # " + this.id + " lost because didn't have enough money");
                return;
            }
            System.out.println("buyer " + id + " can buy some lot with price " + cashAmount);
            Thread.sleep(new Random().nextInt(2000));
            int d = new Random().nextInt(10);
            currentPrice += d;
            currentPrice = currentPrice < cashAmount ? currentPrice : cashAmount;
            System.out.println(id + " made bid = " + currentPrice);
            latchBegin.countDown();
            this.latchEnd.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(id + " continue...");
    }
}
