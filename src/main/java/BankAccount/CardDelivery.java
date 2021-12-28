package BankAccount;

public class CardDelivery {
    public static void main(String[] args) {
        Address address = new Address();

        Client client = new Client();

        try {
            client.addAdress(address);
            System.out.println("Address added successfully.");
        } catch (Exception error) {
            System.err.println("There was an error adding address: " + error.getMessage());
        }
    }
}
