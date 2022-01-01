package ECorpBank.Validation;

import ECorpBank.BankAccount.Account;
import ECorpBank.BankAccount.Client;
import ECorpBank.BankAccount.PersonType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation extends Client {

    public EmailValidation(String firstName, String lastName, String document, String email, String phone, String password, PersonType type, Account account) {
        super(firstName, lastName, document, email, phone, password, type, account);
    }

    public static boolean isEmail(String email) {
        try { String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
            Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = emailPat.matcher(email);
            return matcher.find();
        } catch (Exception error) {
            System.err.println("There was an error adding email: " + error.getMessage());
            return false;
        }

    }
}
