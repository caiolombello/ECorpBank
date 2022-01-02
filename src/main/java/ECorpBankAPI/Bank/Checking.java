package ECorpBankAPI.Bank;

public class Checking extends Account {

    public Checking(int accountId, double deposit) {
        super(accountId);
        this.setBalance(deposit);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }

}
