package ECorpBank.Data;

import ECorpBank.BankAccount.*;

import java.sql.*;

import static ECorpBank.BankAccount.AccountType.Checking;
import static ECorpBank.BankAccount.AccountType.Savings;

public class DbService {
    String url = "jdbc:sqlserver://localhost:1433/ecorpdb";
    String user = "ecorp";
    String password = "passwd";

    private Connection connect() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException error) {
            connection = null;
        }
        return connection;
    }

    // CREATE (Add Account)
    int AddAccount(String firstName, String lastName, String document, String email, String phone, String password, PersonType personType, AccountType accountType, Double balance) {
        int clientId = -1;
        int accountId = -1;
        Connection connection = connect();
        try {
            connection.setAutoCommit(false);
            //Add Client
            String addClientSql = "INSERT INTO Clients(FirstName, LastName, Document, Email, Phone, Password, PersonType) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement addClient = connection.prepareStatement(addClientSql, Statement.RETURN_GENERATED_KEYS);
            addClient.setString(1, firstName);
            addClient.setString(2, lastName);
            addClient.setString(3, document);
            addClient.setString(4, email);
            addClient.setString(5, phone);
            addClient.setString(6, password);
            addClient.setString(7, String.valueOf(personType));
            addClient.executeUpdate();
            ResultSet addClientResults = addClient.getGeneratedKeys();
            if (addClientResults.next()) {
                clientId = addClientResults.getInt(1);
            }
            //Add Account
            String addAccountSql = "INSERT INTO Accounts(Type, Balance) VALUES(?,?)";
            PreparedStatement addAccount = connection.prepareStatement(addAccountSql, Statement.RETURN_GENERATED_KEYS);
            addAccount.setString(1, accountType.name());
            addAccount.setDouble(2, balance);
            addAccount.executeUpdate();
            ResultSet addAccountResults = addAccount.getGeneratedKeys();
            if (addAccountResults.next()) {
                accountId = addAccountResults.getInt(1);
            }
            // Link User to Account
            if (clientId > 0 && accountId > 0) {
                String linkAccountSql = "insert into Mappings(ClientId, AccountId) values(?, ?)";
                PreparedStatement linkAccount = connect().prepareStatement(linkAccountSql, Statement.RETURN_GENERATED_KEYS);
                linkAccount.setInt(1, clientId);
                linkAccount.setInt(2, accountId);
                linkAccount.executeUpdate();
                connection.commit();
            } else {
                connection.rollback();
            }
            connection.close();
        } catch (SQLException error) {
            System.err.println("An error has ocurred: " + error.getMessage());
        }
        return accountId;
    }

    // READ
    Client GetAccount(int accountId) {
        Client client = null;
        Connection connection = connect();
        try {
            String getClientSql = "SELECT FirstName, LastName, Document, Email, Phone, Password, PersonType, Type, Balance" +
                    "from Clients a JOIN Mappings b ON a.ID = b.ClientId" +
                    "join Accounts c ON c.ID = b.AccountId" +
                    "where c.ID = ?";
            PreparedStatement getClient = connection.prepareStatement(getClientSql);
            getClient.setInt(1, accountId);
            ResultSet getUserResults = getClient.executeQuery();
            if (getUserResults.next()) {
                String firstName = getUserResults.getString("FirstName");
                String lastName = getUserResults.getString("LastName");
                String document = getUserResults.getString("Document");
                String email = getUserResults.getString("Email");
                String phone = getUserResults.getString("Phone");
                String password = getUserResults.getString("Password");
                PersonType personType = PersonType.valueOf(getUserResults.getString("PersonType"));
                AccountType accountType = AccountType.valueOf(getUserResults.getString("Type"));
                double balance = getUserResults.getDouble("Balance");
                Account account;
                if (accountType == Checking) {
                    account = new Checking(accountId, balance);
                } else if (accountType == Savings) {
                    account = new Savings(accountId, balance);
                } else {
                    throw new Exception(("Unknown account type"));
                }
                client = new Client(firstName, lastName, document, email, phone, password, personType, account);
            } else {
                System.err.println("No user account was found for ID " + accountId);
            }
        } catch (Exception error) {
            System.err.println(error.getMessage());
        }
        return client;
    }

    // UPDATE
    boolean UpdateAccount(int accountId, double balance) {
        boolean success = false;
        Connection connection = connect();
        try {
            String updateSql = "UPDATE Accounts SET Balance = ? WHERE ID = ?";
            PreparedStatement updateBalance = connection.prepareStatement(updateSql);
            updateBalance.setDouble(1, balance);
            updateBalance.setInt(2, accountId);
            updateBalance.executeUpdate();
            success = true;
        } catch (SQLException error) {
            System.err.println(error.getMessage());
        }
        return success;
    }

    // DELETE
    boolean DeleteAccount(int accountId) {
        boolean success = false;
        Connection connection = connect();
        try {
            String deleteSql = "DELETE Clients, Accounts" +
                    "from Clients a JOIN Mappings b ON a.ID = b.ClientId" +
                    "join Accounts c ON c.ID = b.AccountId" +
                    "where c.ID = ?";
            PreparedStatement deleteAccount = connection.prepareStatement(deleteSql);
            deleteAccount.setInt(1, accountId);
            deleteAccount.executeUpdate();
            success = true;
        } catch (SQLException error) {
            System.err.println(error.getMessage());
        }
        return success;
    }

}
