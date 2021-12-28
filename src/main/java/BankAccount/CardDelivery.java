package BankAccount;

import Validation.AddressValidation;

public class CardDelivery {
    public String cardNumber;

    public static void main(String[] args) {
        Address address = new Address();

        Client client = new Client();

        address.setAddress("Street");
        address.setAddressNumber("123");
        address.setDistrict("District");
        address.setCity("City");
        address.setState("State");
        address.setCountry("Country");
        address.setZipCode("00000");

        try {
            AddressValidation.addAdress(address);
            System.out.printf("%s\n%s, %s\n%s\n%s - %s\n%s\n%s",
                    address.getAddressComplement(), address.getAddress(), address.getAddressNumber(), address.getDistrict(), address.getCity(), address.getState(), address.getCountry(), address.getZipCode());
            System.out.println("\nAddress added successfully.");
        } catch (Exception error) {
            System.err.println("There was an error adding address: " + error.getMessage());
        }
    }
}
