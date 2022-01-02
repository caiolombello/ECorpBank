package ECorpBankAPI.Bank;

import ECorpBankAPI.Data.DbService;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;

public class Bank {

    // Database
    private final DbService database = new DbService();

    // Account
    Client openAccount(String firstName, String lastName, String document, String email, String phone, String password, PersonType personType, AccountType accountType, Double balance) {
        int accountId = database.AddAccount(firstName, lastName, document, email, phone, password, personType, accountType, balance);
        return database.GetAccount(accountId);
    }

    boolean closeAccount(int accountId) {
        return database.DeleteAccount(accountId);
    }

    Client getClient(int accountId) {
        return database.GetAccount(accountId);
    }

    ArrayList<Client> getClients() {
        return database.GetAllAccounts();
    }

    // Transactions
    void withdraw(int accountId, double amount) throws InsufficientResourcesException {
        Client client = getClient(accountId);
        if (amount > Double.parseDouble(String.valueOf(client.getAccount().getAccountType()))){
        throw new InsufficientResourcesException();
        }
        double newBalance = client.getAccount().getBalance() - amount;
        database.UpdateAccount(accountId, newBalance);
    }

    void deposit(int accountId, double amount) throws InsufficientResourcesException {
        Client client = getClient(accountId);
        if(amount <= 0) {
            throw new InsufficientResourcesException();
        }
        database.UpdateAccount(accountId, client.getAccount().getBalance() + amount);
    }



}
