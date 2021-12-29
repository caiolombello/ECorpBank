package Validation;

import BankAccount.Address;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AddressValidation {
    public static List<Address> addresses;

    public static void addAdress(@NotNull Address address) {

        if (ZipValidation.isZIP(address.getZipCode())) {
            address.setZipCode(address.getZipCode());
        }
        else throw new RuntimeException("Invalid ZIP Code.");

        getAddresses().add(address);
    }

    private static List<Address> getAddresses() {
        if (addresses == null) {
            addresses = new ArrayList<Address>();
        }
        return addresses;
    }
}
