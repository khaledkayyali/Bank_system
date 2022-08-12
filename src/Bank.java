import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;

 class Bank {

     float bankBalance = 0;
    private static Bank bankObject;

    public static Bank getInstance(){
        if (bankObject == null){
            bankObject = new Bank();
        }
        return  bankObject;
    }

     private static float  totalCommission(){
         //TODO how to add all

         return totalCommission();
     }
     public static float updateTotalCommission(){
         return totalCommission();
     }

    private Logger logService;
    private Client[] clients;
    //private accountUpdater


    private Bank() {
        clients = new Client[99];
    }

    float getBalance() {
        //bankBalance
        for (Client client : clients) {
            bankBalance += client.getFortune();
        }
        return bankBalance;
    }

    void addClient(Client client) {
        for (Client arrayClient : clients) {
            if (client.getId() == arrayClient.getId()) {
                System.out.println("The client exists");
                break;
            }
            for (int j = 0; j <clients.length; j++) {
                if (clients[j] == null){
                    clients[j] = client;
                    Log log = new Log(Instant.now().toEpochMilli(), client.getId(),"the client added",0);
                    Logger.log(log);
                }
            }
        }

    }
        //TODO REVIEW
    void removeClient(Client client) {
        for (int i = 0; i <clients.length ; i++) {
            clients.equals(client);
            clients[i] = null;

            Log log = new Log(Instant.now().toEpochMilli(), clients[i].getId(),"the client removed",0);
            Logger.log(log);

        }
    }

    public Client[] getClients() {
        return clients;
    }

    /*Log logAll = new Log();
    Logger  */
    //view logs

    void startAccountUpdater() {

    }

    void setBalance(){
        bankBalance += totalCommission();
    }

    void printClientList(){

    }

}
