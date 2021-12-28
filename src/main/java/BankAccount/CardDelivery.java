package BankAccount;

import java.util.ArrayList;

public class CardDelivery {
    public static void main(String[] args) {
        Address address = new Address();

        Client client = new Client();

        if (client.addresses == null) {
            client.addresses = new ArrayList<Address>();
        }

        client.addresses.add(address);
        System.out.println("Address added successfully.");
    }
}
