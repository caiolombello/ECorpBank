package BankAccount;

import Validation.DocumentValidation;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public enum PersonType {PHYSICAL, LEGAL}

    private Integer id;
    private String name;
    private String document;

    private static final int CPF_LENGHT = 11;
    private static final int CNPJ_LENGHT = 14;

    public PersonType type;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        if (document == null || document.isEmpty()) {
            throw new RuntimeException("Document cannot be null or empty.");
        }

        if (document.length() == CPF_LENGHT) {
            if (DocumentValidation.isCPF(getDocument())) type = PersonType.PHYSICAL;
        }
        else if (document.length() == CNPJ_LENGHT) {
            if (DocumentValidation.isCNPJ(getDocument())) type = PersonType.LEGAL;
        } else throw new RuntimeException("Invalid document for physical or legal person.");

        this.document = document;
    }

    public PersonType getType() {
        return type;
    }

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
