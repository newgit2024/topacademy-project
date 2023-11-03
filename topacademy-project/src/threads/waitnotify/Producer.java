package threads.waitnotify;

public class Producer extends Thread {
    private final Product product;

    public Producer(Product product) {
        super("Producer");
        this.product = product;
    }

    @Override
    public void run() {
        while (true){
            synchronized (product){
                System.out.println("Check if  product was consumed");
                while(!product.isConsumed()){
                    System.out.println("Timeout before product consuming");
                    try {
                        product.wait();//waited
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Producer is producing product...");
                product.produce();
                System.out.println("Producer is notifying consumer...");
                product.notify();
            }
        }
    }
}
