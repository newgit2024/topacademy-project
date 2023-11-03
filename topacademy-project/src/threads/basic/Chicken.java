package threads.basic;

public class Chicken extends  Thread{

    public Chicken() {
        super("Chicken");
    }

    @Override
    public void run() {
        for(int i = 0; i < 100_000; i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
