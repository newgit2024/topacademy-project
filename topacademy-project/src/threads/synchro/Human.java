package threads.synchro;

public class Human extends Thread {
    private final Card card;
    private String name;

    public Human(Card card, String name) {
        this.card = card;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            synchronized (card) {
                if (card.getAmount() > 0){
                    System.out.println("buy phone");
                    if (card.buy(100)){
                        System.out.println("phone was purchased");
                    } else {
                        System.out.println("fail!!!");
                    }
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
