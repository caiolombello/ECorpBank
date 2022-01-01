package ECorpBank.Data;

import ECorpBank.BankAccount.AccountType;

import java.sql.*;

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

    // CRUD
    // CREATE (Add Account)
    int AddAccount(String firstName, String lastName, String document, AccountType accountType, Double balance){
        int clientId = -1;
        int accountId = -1;
        Connection connection = connect();
        try {
            connection.setAutoCommit(false);
            //Add Client
            String addClientSql = "insert into Clients(FirstName, LastName, document) values(?,?,?)";
            PreparedStatement addClient = connection.prepareStatement(addClientSql, Statement.RETURN_GENERATED_KEYS);
            addClient.setString(1, firstName);
            addClient.setString(2, lastName);
            addClient.setString(3, document);
            addClient.executeUpdate();
            ResultSet addClientResults = addClient.getGeneratedKeys();
            if(addClientResults.next()) {
                clientId = addClientResults.getInt(1);
            }
            //Add Account
            String addAccountSql = "insert into Accounts(Type, Balance) values(?,?)";
            PreparedStatement addAccount = connection.prepareStatement(addAccountSql, Statement.RETURN_GENERATED_KEYS);
            addAccount.setString(1, accountType.name());
            addAccount.setDouble(2, balance);
            addAccount.executeUpdate();
            ResultSet addAccountResults = addAccount.getGeneratedKeys();
            if(addAccountResults.next()) {
                accountId = addAccountResults.getInt(1);
            }
            // Link User to Account
            if(clientId > 0 && accountId > 0) {
                String linkAccountSql = "insert into Mappings(ClientId, AccountId) values(?, ?)";
                PreparedStatement linkAccount = connect().prepareStatement(linkAccountSql, Statement.RETURN_GENERATED_KEYS);
                linkAccount.setInt(1, clientId);
                linkAccount.setInt(2, accountId);
                linkAccount.executeUpdate();
                connection.commit();
            }
            else {
                connection.rollback();
            }
            connection.close();
        } catch (SQLException error) {
            System.err.println("An error has ocurred: " + error.getMessage());
        }
        return accountId;
    }

    // READ
    // UPDATE
    // DELETE

}
