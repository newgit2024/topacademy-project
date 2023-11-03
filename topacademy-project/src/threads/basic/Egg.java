package threads.basic;

public class Egg extends  Thread{

    public Egg() {
        super("Egg");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < 100_000; i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
