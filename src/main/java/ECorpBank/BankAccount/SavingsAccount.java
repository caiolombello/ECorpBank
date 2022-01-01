package ECorpBank.BankAccount;

public class SavingsAccount extends Account {

    public SavingsAccount(Client client) {
        super(client);
    }

    @Override
    public void printExtract() {
        System.out.println("\nSavings Account Extract\n");
        super.printAccountData();
    }


}
