package staticjava.logger;

public class ConsoleMonitoring {
    public static void main(String[] args) {
        //ConsoleLogger consoleLogger = new ConsoleLogger();
        ConsoleLogger logger1 = ConsoleLogger.getInstance();
        ConsoleLogger logger2 = ConsoleLogger.getInstance();

        logger1.info("Running...");
        logger1.error("...Something went wrong...");

        logger2.info("Logging with another logger...");
        logger2.error("...Something went wrong...AGAIN");
    }
}
