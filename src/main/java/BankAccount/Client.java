package BankAccount;

import Validation.DocumentValidation;
import Validation.EmailValidation;
import Validation.PasswordValidation;
import Validation.PhoneValidation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

        if (DocumentValidation.validationCPF(document)) setDocument(document, PersonType.PHYSICAL);
        else if (DocumentValidation.validationCNPJ(document)) setDocument(document, PersonType.LEGAL);

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
        if (email == null || email.isEmpty()) {
            throw new RuntimeException("Email cannot be null or empty.");
        }

        if (EmailValidation.isEmail(getEmail())) setEmail(email);
        else throw new RuntimeException("Invalid email.");

        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            throw new RuntimeException("Phone cannot be null or empty.");
        }

        if (PhoneValidation.isPhone(getPhone())) setPhone(phone);
        else throw new RuntimeException("Invalid phone number. (Try (xx) xxxxx-xxxx)");

        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new RuntimeException("Password cannot be null or empty.");
        }

        if (PasswordValidation.isValidPassword(getPassword())) setPassword(password);

        this.password = password;
    }
}
