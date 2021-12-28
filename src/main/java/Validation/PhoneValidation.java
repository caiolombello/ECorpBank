package Validation;

import BankAccount.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidation extends Client {
    public static boolean isPhone(String phone) {
        Pattern p = Pattern.compile("^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}-[0-9]{4}$");
        Matcher m = p.matcher(phone);
        return (m.matches());
    }
}
