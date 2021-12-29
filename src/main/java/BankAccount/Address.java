package BankAccount;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class Address {

    private enum AddressType {
        RESIDENTIAL,
        DELIVERY,
        WORK
    }

    @NotNull private String address, addressNumber, district, city, state, country, zipCode;
    private String addressComplement;

}
