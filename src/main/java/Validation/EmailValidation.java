package Validation;

import BankAccount.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation extends Client {
    public static boolean isEmail(String email){
        Pattern p = Pattern.compile("^(.+)@(.+)$");
        Matcher m = p.matcher(email);
        return (m.matches());
    }
}
