package ECorpBank.BankAccount;

import lombok.Getter;

@Getter
public abstract class Account implements Transactions {

    private static final int DEFAULT_AGENCY = 1;
    private static int SEQUENTIAL = 1;

    protected int agency;
    protected int number;
    protected double balance = 0;

    public Account(int number) {
        this.agency = Account.DEFAULT_AGENCY;
        this.number = SEQUENTIAL++;
    }

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

    @Override
    public void withdraw(double value) {
        balance -= value;
    }

    @Override
    public void deposit(double value) {
        balance += value;
    }

    @Override
    public void transfer(double value, Account accountDestination){
        this.withdraw(value);
        accountDestination.deposit(value);
    }

}
