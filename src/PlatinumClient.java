public class PlatinumClient extends Client{

    float commissionRate = 0.01f;
    float interestRate = 0.05f;

    public PlatinumClient(int id, String name, float balance) {
        super(id, name, balance);

    }

    @Override
    public String toString() {
        return "PlatinumClient{" + getId() +
                "} " + super.toString();
    }
}
