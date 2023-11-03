package threads.conccurent2.semaphore;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<RadioChannel> radioChannels = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            radioChannels.add(new RadioChannel(i));
        }

        ChannelSet<RadioChannel> set = new ChannelSet<>(radioChannels);
        for(int i = 0; i < 30; i++){
            new Client(set).start();
        }
    }
}
