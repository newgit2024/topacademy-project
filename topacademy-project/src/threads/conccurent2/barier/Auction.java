package threads.conccurent2.barier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class Auction extends Thread{
    private List<Buyer> buyerList;
    public static CountDownLatch auctionLatch = new CountDownLatch(1);
    public static CountDownLatch auctionLatchBegin;


    public Auction(int buyersCount) {
        auctionLatchBegin = new CountDownLatch(buyersCount);
        buyerList = new ArrayList<>();
    }
    public boolean add(Buyer buyer){
        return buyerList.add(buyer);
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting...");
            auctionLatchBegin.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Buyer win = checkWinner();
        auctionLatch.countDown();
        System.out.println(win);
    }

    private Buyer checkWinner (){
        Buyer winner = Collections.max(buyerList.stream()
                .filter(o -> !o.isLost())
                .collect(Collectors.toList()),
                Comparator.comparingInt(Buyer::getCurrentPrice));
        System.out.println(winner.getId() + " : " + winner.getCurrentPrice());
        winner.setCashAmount(winner.getCashAmount() - winner.getCurrentPrice());
        return winner;
    }
}
