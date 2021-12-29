package BankAccount;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private enum AddressType {
        RESIDENTIAL,
        DELIVERY,
        WORK
    }

    private String address;
    private String addressNumber;
    private String addressComplement;
    private String district;
    private String city;
    private String state;
    private String country;
    private String zipCode;

}
