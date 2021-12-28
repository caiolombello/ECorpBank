package BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public enum PersonType {PHYSICAL, LEGAL}

    private Integer code;
    private String name;
    private String cpf;
    private String cnpj;
    private String id;
    public PersonType type;

    public List<Address> addresses;

    public void addAdress(Address address) {
        if (address == null) {
            throw new NullPointerException("Address cannot be null.");
        }

        if (address.getZipCode() == null) {
            throw new NullPointerException("ZIP Code cannot be null.");
        }

        getAddresses().add(address);
    }
    
    private List<Address> getAddresses() {
        if (addresses == null) {
            addresses = new ArrayList<Address>();
        }
        return addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
