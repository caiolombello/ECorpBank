package ECorpBankAPI.Bank;

import ECorpBankAPI.Bank.Address;
import ECorpBankAPI.Validation.AddressValidation;

public class CardDelivery {

    public static void main(String[] args) {
        Address address = new Address();

        try {
            AddressValidation.addAddress(address);
            System.out.printf("%s\n%s, %s\n%s\n%s - %s\n%s\n%s",
                    address.getAddressComplement(), address.getAddress(), address.getAddressNumber(), address.getDistrict(), address.getCity(), address.getState(), address.getCountry(), address.getZipCode());
            System.out.println("\nAddress added successfully.");
        } catch (Exception error) {
            System.err.println("There was an error adding address: " + error.getMessage());
        }
    }
}
