package threads.conccurent2.semaphore;

public class Client extends Thread {
    private ChannelSet<RadioChannel> set;

    public Client(ChannelSet<RadioChannel> set) {
        this.set = set;
    }

    @Override
    public void run() {
        RadioChannel channel = null;
        try {
            channel = set.getResourceInfo(this, 500);
            channel.listen();
        } catch (ChannelException e) {
            System.err.println("Client" + this.getId() + " " + e.getMessage());
        } finally {
            if (channel != null){
                set.releaseResource(this, channel);
            }
        }
    }
}
