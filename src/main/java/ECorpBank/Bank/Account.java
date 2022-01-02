package ECorpBank.Bank;

import lombok.Getter;

@Getter
public abstract class Account {

    private static final int DEFAULT_AGENCY = 1;
    private static int SEQUENTIAL = 1;

    protected int agency;
    protected int number;
    protected double balance = 0;

    public abstract AccountType getAccountType();

    @Override
    public String toString() {
        return "Account Type: " + getAccountType().name() + " Account\n" +
                "Account Number: " + this.getNumber() + "\n" +
                "Balance: " + this.getBalance() + "\n";
    }

    public final void setBalance(double balance) {
        this.balance = balance;
    }

}
