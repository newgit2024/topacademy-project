package threads.synchro;

public class Card {
    private int amount;

    public Card(int amount) {
        this.amount = amount;
    }


    public int getAmount() {
        return amount;
    }

    public synchronized boolean buy (int price){
        if (amount >= price){
            this.amount -= price;
            return true;
        } else {
            System.err.println("LOW BALANCE");
            return false;
        }
    }
}
