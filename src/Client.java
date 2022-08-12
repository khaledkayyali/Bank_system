import java.time.Instant;
import java.util.Objects;

public abstract class Client {

    private int id;
    private String name;
    private float balance;
    private Account[] accounts;
    protected float commission = 0;
    protected float interest = 0;
    protected final float commissionRate =0;
    protected final float interestRate=0;

    private Logger logger;

    //Log log = new Log(Instant.now().toEpochMilli(), id, "Account Added", 0);

    public Client() {
    }

    public Client(int id, String name, float balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        logger = new Logger(name);
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    void addAccount(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getId() == account.getId()) {
                System.out.println("Account ID exists");
                break;
            }
            if (accounts[i] == null) {
                accounts[i] = new Account(getId(), getBalance());
                Log log = new Log(Instant.now().toEpochMilli(), id, "Account Added", 0);
                Logger.log(log);
            }
        }
    }

    //TODO return empty account
    Account getAccount(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    void removeAccount(int id) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getId() == id) {
                balance = accounts[i].getBalance() + balance;
                accounts[i] = null;
                Log log = new Log(Instant.now().toEpochMilli(), id, "Account Removed", balance);
                Logger.log(log);
            }
        }
    }

    float deposit(float amount) {
        balance = balance + amount - commission;
        return balance;
    }

    float withdraw(float amount) {
        commission = amount*commissionRate;
        balance = balance - amount - commission;
        Bank.updateTotalCommission();
        return balance;
    }

    void autoUpdateAccounts() {
        for (Account account : accounts) {
            account.setBalance(account.getBalance() * (1 + interest));
        }
        Log log = new Log(Instant.now().toEpochMilli(), id, "Balance Updated", balance);
        Logger.log(log);
    }

    float getFortune() {
        float allBalances = 0;
        for (Account account : accounts) {
           allBalances += account.getBalance();
        }
        //TODO to be tested
        return allBalances + getBalance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
