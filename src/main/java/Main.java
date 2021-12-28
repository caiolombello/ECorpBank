import BankAccount.Account;
import BankAccount.CheckingAccount;
import BankAccount.Client;
import BankAccount.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        Client Caio = new Client();
        Caio.setName("Caio");

        Account checkingAccount = new CheckingAccount(Caio);
        Account savingsAccount = new SavingsAccount(Caio);

        checkingAccount.deposit(100);
        checkingAccount.transfer(100, savingsAccount);

        checkingAccount.printExtract();
        savingsAccount.printExtract();
    }
}
