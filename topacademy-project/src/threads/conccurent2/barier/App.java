package threads.conccurent2.barier;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        int buyersCount = 5;
        Auction auction = new Auction(buyersCount);
        int startPrice = 100;
        auction.start();
        for (int i = 0; i < buyersCount; i++){
            int cashAmount = 100 + new Random().nextInt(10);
            Buyer buyer = new Buyer(i, startPrice, cashAmount);
            auction.add(buyer);
            buyer.start();
        }
    }
}
