package BankAccount;

public class CheckingAccount extends Account {

    public CheckingAccount(Client client) {
        super(client);
    }

    @Override
    public void printExtract() {
        System.out.println("\nChecking Account Extract\n");
        super.printAccountData();
    }
}
