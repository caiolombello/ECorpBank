package ECorpBankAPI.Bank;

import lombok.Getter;

@Getter
public abstract class Account {

    protected int accountNumber;
    protected double balance = 0;

    public abstract AccountType getAccountType();

    Account(int accountId) {
        accountNumber = accountId;
    }

    public final void setBalance(double balance) {
        this.balance = balance;
    }

}
