public class Log {

    long timeStamp;
    int clientId;
    String description;
    float amount;

    public Log(){

    }

    public Log(long timeStamp, int clientId, String description, float amount) {
        this.timeStamp = timeStamp;
        this.clientId = clientId;
        this.description = description;
        this.amount = amount;
    }

    public String toString() {
        return "Log{" +
                "timeStamp=" + timeStamp +
                ", clientId=" + clientId +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
