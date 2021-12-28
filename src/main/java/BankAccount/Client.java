package BankAccount;

import Validation.DocumentValidation;
import Validation.EmailValidation;

public class Client {

    public enum PersonType {PHYSICAL, LEGAL}

    private Integer id;
    private String name;
    private String document;
    private String email;
    private String phone;
    private String password;

    public PersonType type;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        if (document == null || document.isEmpty()) {
            throw new RuntimeException("Document cannot be null or empty.");
        }

        if (DocumentValidation.isCPF(getDocument())) setDocument(document, PersonType.PHYSICAL);
        else if (DocumentValidation.isCNPJ(getDocument())) setDocument(document, PersonType.LEGAL);
        else throw new RuntimeException("Invalid document for physical or legal person.");

        this.document = document;
    }

    private void setDocument(String document, PersonType type) {
        this.document = document;
        this.type = type;
    }

    public PersonType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //if (EmailValidation.isEmail(getEmail()))

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
