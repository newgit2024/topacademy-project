package threads.conccurent2.semaphore;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Channel {
    private volatile boolean busy;


    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public abstract void listen();
}
