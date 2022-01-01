package ECorpBank.BankAccount;

import lombok.Getter;

@Getter
public abstract class Account implements Transactions {

    private static final int DEFAULT_AGENCY = 1;
    private static int SEQUENTIAL = 1;

    protected int agency;
    protected int number;
    protected double balance;
    protected Client client;

    public Account(Client client) {
        this.agency = Account.DEFAULT_AGENCY;
        this.number = SEQUENTIAL++;
        this.client = client;
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

    protected void printAccountData() {
        System.out.printf("Holder: %s", client.getName());
        System.out.printf("\nAgency: %d", agency);
        System.out.printf("\nNumber: %d", number);
        System.out.printf("\nBalance: %.2f\n", balance);
    }
}
