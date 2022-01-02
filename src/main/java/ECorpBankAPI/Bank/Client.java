package ECorpBankAPI.Bank;

import ECorpBankAPI.Validation.DocumentValidation;
import ECorpBankAPI.Validation.EmailValidation;
import ECorpBankAPI.Validation.PhoneValidation;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class Client {

    private Integer id;
    @NotNull
    private String firstName, lastName, document, email, phone, password;
    public String fullName = firstName + lastName;
    private PersonType type;
    private Account account;

    public Client(String firstName, String lastName, String document, String email, String phone, String password, PersonType type, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.type = type;
        this.account = account;
    }

    public String basicInfo() {
        return " Account Number: " + account.getAccountNumber() + " - Name: " + getFullName();
    }

    // Setters with Validation
    public void setDocument(String document) {

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

        if (EmailValidation.isEmail(email)) {
            this.email = email;
        } else throw new RuntimeException("Invalid email.");
    }

    public void setPhone(String phone) {

        if (PhoneValidation.isPhone(phone)) {
            this.phone = phone;
        } else throw new RuntimeException("Invalid phone number. (Try (xx) xxxxx-xxxx)");
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new RuntimeException("Password cannot be null or empty.");
        }
        this.password = password;
    }
}