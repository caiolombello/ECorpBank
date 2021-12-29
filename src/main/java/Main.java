import BankAccount.Account;
import BankAccount.CheckingAccount;
import BankAccount.Client;
import BankAccount.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        Client Caio = new Client();
        Caio.setName("Caio");
        // Caio.setPassword("passwd");
        //Caio.setEmail("caiolombello@gmail.com");
        // Caio.setDocument("12345678910");
        // Caio.setPhone("(12) 34567-8910");

        Account checkingAccount = new CheckingAccount(Caio);
        Account savingsAccount = new SavingsAccount(Caio);

        checkingAccount.deposit(100);
        checkingAccount.transfer(100, savingsAccount);

        checkingAccount.printExtract();
        savingsAccount.printExtract();
    }
}
