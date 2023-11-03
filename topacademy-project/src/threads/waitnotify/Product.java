package threads.waitnotify;

public class Product {
    private boolean isReady;
    public boolean isProduced(){
        return isReady;
    }
    public boolean isConsumed(){
        return !isReady;
    }
    public void consume(){
        this.isReady = false;
    }

    public void produce(){
        this.isReady = true;
    }
}
