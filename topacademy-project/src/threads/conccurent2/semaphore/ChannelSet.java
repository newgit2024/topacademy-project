package threads.conccurent2.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ChannelSet<T extends Channel> {
    private final static int SIZE = 5;
    private Semaphore semaphore = new Semaphore(SIZE, true);
    private ArrayList<T> resources = new ArrayList<>();


    public ChannelSet(List<T> src) {
        this.resources.addAll(src);
    }

    public T getResourceInfo(Client client, long maxTimeOut) throws ChannelException {
        try {
            if (semaphore.tryAcquire(maxTimeOut, TimeUnit.MILLISECONDS)) {
                for (T r : resources){
                    if (!r.isBusy()){
                        r.setBusy(true);
                        System.out.println("client# " + client.getId() + " listen " + r);
                        return  r;
                    }
                }

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        throw new ChannelException("time out limit..." + maxTimeOut);
    }

    public void releaseResource (Client client, T resource){
        resource.setBusy(false);
        System.out.println("client " + client.getId() + "released resource " + resource);
        semaphore.release();
    }
}
