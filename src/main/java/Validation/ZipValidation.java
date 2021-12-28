package Validation;

import BankAccount.Address;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipValidation extends Address {
    public static boolean isZIP(String zip) {
        boolean isZipValid = false;
        String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(zip);
        if (matcher.matches()) {
            isZipValid = true;
        }
        return isZipValid;
    }
}
