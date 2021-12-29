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
    private String name, document, email, phone, password;

    public PersonType type;

    public void setDocument(String document) {
        if (document == null || document.isEmpty()) {
            throw new RuntimeException("Document cannot be null or empty.");
        }

        if (document.length() == 11) {
            if (DocumentValidation.validationCPF(document)) setDocument(document, PersonType.PHYSICAL);
        } else if (document.length() == 14) {
            if (DocumentValidation.validationCNPJ(document)) setDocument(document, PersonType.LEGAL);
        } else throw new RuntimeException("Invalid document number.");

        this.document = document;
    }

    private void setDocument(String document, PersonType type) {
        this.document = document;
        this.type = type;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new RuntimeException("Email cannot be null or empty.");
        }

        if (EmailValidation.isEmail(email)) {
            this.email = email;
        }
        else throw new RuntimeException("Invalid email.");
    }

    public void setPhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            throw new RuntimeException("Phone cannot be null or empty.");
        }

        if (PhoneValidation.isPhone(getPhone())) setPhone(phone);
        else throw new RuntimeException("Invalid phone number. (Try (xx) xxxxx-xxxx)");

        this.phone = phone;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new RuntimeException("Password cannot be null or empty.");
        } else if (!password.equals(getPassword())) throw new RuntimeException("User or password is invalid.");

        if (PasswordValidation.isValidPassword(getPassword())) setPassword(password);

        this.password = password;
    }
}