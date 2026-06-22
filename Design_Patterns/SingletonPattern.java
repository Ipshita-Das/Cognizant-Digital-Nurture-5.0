class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(message);
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        l1.log("Testing logger instance...");

        if (l1 == l2) {
            System.out.println("Success: Both l1 and l2 are the exact same instance.");
        } else {
            System.out.println("Fail: Instances are different.");
        }
    }
}