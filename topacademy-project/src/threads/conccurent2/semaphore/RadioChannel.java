package threads.conccurent2.semaphore;

import java.util.Random;

public class RadioChannel extends Channel{
    private int id;

    public RadioChannel(int id) {
        this.id = id;
    }

    @Override
    public void listen() {
        try {
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RadioChannel{" +
                "id=" + id +
                '}';
    }
}
