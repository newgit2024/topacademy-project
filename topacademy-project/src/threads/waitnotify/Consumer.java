package threads.waitnotify;

public class Consumer extends Thread {
    private final Product product;

    public Consumer(Product product) {
        super("Consumer");
        this.product = product;
    }

    @Override
    public void run() {
        while (true){
            synchronized (product){
                System.out.println("Check if  product was produced");
                while(!product.isProduced()){
                    System.out.println("Timeout before product producing...");
                    try {
                        product.wait();//new -> runnable -> waited -> runnable -> terminated
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Consumer is consuming product...");
                product.consume();
                System.out.println("Consumer is notifying producer...");
                product.notify();
            }
        }
    }
}
