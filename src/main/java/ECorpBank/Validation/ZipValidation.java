package ECorpBank.Validation;

import ECorpBank.BankAccount.Address;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipValidation extends Address {
    public static boolean isZIP(String zip) {
        try {
            String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(zip);
            return matcher.matches();
        } catch (Exception error) {
            System.err.println("There was an error adding ZIP Code: " + error.getMessage());
            return false;
        }
    }
}
