package ECorpBankAPI.Bank;

public class Savings extends Account {

    public Savings(int accountId, double deposit) {
        super(accountId);
        this.setBalance(deposit);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }

}
