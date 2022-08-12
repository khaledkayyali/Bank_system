public class RegularClient extends Client{

    //TODO for withdraw
    float commissionRate = 0.03f;
    float interestRate = 0.01f;

    public RegularClient(int id, String name, float balance) {
        super(id, name, balance);
    }

    @Override
    public String toString() {
        return "RegularClient{} "+ getId() + super.toString();
    }
}
