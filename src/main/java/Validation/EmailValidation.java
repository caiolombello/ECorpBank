package Validation;

import BankAccount.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation extends Client {
    public static boolean isEmail(String email){
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }
}
