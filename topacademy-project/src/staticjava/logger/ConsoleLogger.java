package staticjava.logger;

import java.time.LocalDateTime;

public class ConsoleLogger {
    private final static ConsoleLogger instance;

    static {
       instance = new ConsoleLogger();
    }
    private ConsoleLogger(){
    }
    public static ConsoleLogger getInstance(){
        return instance;
    }
    public void info(String message){
        System.out.println(LocalDateTime.now() + " : " + message);
    }
    public void error(String message){
        System.err.println(LocalDateTime.now() + " : " + message);
    }
}
