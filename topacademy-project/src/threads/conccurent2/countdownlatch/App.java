package threads.conccurent2.countdownlatch;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        int buyersCount = 5;
        Auction auction = new Auction(buyersCount);
        int startPrice = 100;
        for (int i = 0; i < buyersCount; i++){
            int cashAmount = 100 + new Random().nextInt(50);
            Buyer buyer = new Buyer(i, startPrice, cashAmount);
            auction.add(buyer);
            buyer.start();
        }
    }
}
