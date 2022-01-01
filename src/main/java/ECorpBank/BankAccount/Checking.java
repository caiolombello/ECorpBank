package ECorpBank.BankAccount;

public class Checking extends Account {

    public Checking(int number, double deposit) {
        super(number);
        this.setBalance(deposit);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.Checking;
    }

}
