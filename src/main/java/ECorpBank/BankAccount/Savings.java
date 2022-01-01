package ECorpBank.BankAccount;

public class Savings extends Account {

    public Savings(int number, double deposit) {
        super(number);
        this.setBalance(deposit);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.Savings;
    }

}
