package threads.conccurent2.countdownlatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;

public class Auction {
    private List<Buyer> buyerList;
    public static CyclicBarrier barrier;

    public Auction(int buyersCount) {
        buyerList = new ArrayList<>();
        this.barrier = new CyclicBarrier(buyersCount, () -> checkWinner());
    }
    public boolean add(Buyer buyer){
        return buyerList.add(buyer);
    }

    private Buyer checkWinner (){
        Buyer winner = Collections.max(buyerList,
                Comparator.comparingInt(Buyer::getCurrentPrice));
        System.out.println(winner.getId() + " : " + winner.getCurrentPrice());
        winner.setCashAmount(winner.getCashAmount() - winner.getCurrentPrice());
        return winner;
    }


}
