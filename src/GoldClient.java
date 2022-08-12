public class GoldClient extends Client {

    float commissionRate = 0.02f;
    float interestRate = 0.03f;

    public GoldClient(int id, String name, float balance) {
        super(id, name, balance);
    }

    @Override
    public String toString() {
        return "GoldClient{} " + getId() + super.toString();
    }
}
