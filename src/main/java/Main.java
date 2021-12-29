import BankAccount.Account;
import BankAccount.CheckingAccount;
import BankAccount.Client;
import BankAccount.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        Client Caio = new Client();
        Caio.setName("Caio");
        // Caio.setPassword("passwd");
        // Caio.setEmail("caio@example.com");
        // Caio.setDocument("34550807075");
        // Caio.setPhone("(12) 34567-8910");

        Account checkingAccount = new CheckingAccount(Caio);
        Account savingsAccount = new SavingsAccount(Caio);

        checkingAccount.deposit(100);
        checkingAccount.transfer(100, savingsAccount);

        checkingAccount.printExtract();
        savingsAccount.printExtract();
    }
}
