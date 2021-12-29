package Validation;

import BankAccount.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressValidation {
    public static List<Address> addresses;

    public static void addAdress(Address address) {
        if (address.getAddress() == null) {
            throw new NullPointerException("Address cannot be null.");
        }

        if (address.getAddressNumber() == null) {
            throw new NullPointerException("Address number cannot be null.");
        }

        if (address.getDistrict() == null) {
            throw new NullPointerException("District cannot be null.");
        }

        if (address.getCity() == null) {
            throw new NullPointerException("City cannot be null.");
        }

        if (address.getState() == null) {
            throw new NullPointerException("State cannot be null.");
        }

        if (address.getCountry() == null) {
            throw new NullPointerException("Country cannot be null.");
        }

        if (ZipValidation.isZIP(address.getZipCode())) throw new RuntimeException("Invalid ZIP Code.");
        else if (address.getZipCode() == null) throw new NullPointerException("ZIP Code cannot be null.");


        getAddresses().add(address);
    }

    private static List<Address> getAddresses() {
        if (addresses == null) {
            addresses = new ArrayList<Address>();
        }
        return addresses;
    }
}
