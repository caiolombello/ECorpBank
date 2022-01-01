package ECorpBank.BankAccount;

public interface Transactions {

    void withdraw(double value);

    void deposit(double value);

    void transfer(double valor, Account accountDestination);

    void printExtract();
}
