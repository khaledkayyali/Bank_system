public class Logger {

    String driverName;

    public Logger(String driverName) {
        this.driverName = driverName;
    }

    public static void log(Log log) {
        System.out.println(log.toString());
    }

    public Log[] getLogs() {
        return new Log[0];
    }
}
