package Validation;

import BankAccount.Client;

public class PasswordValidation extends Client {
    public static boolean isValidPassword(String password) {
        boolean isValid = true;
        String error = null;
        if (password.length() > 15 || password.length() < 8) {
            error = "Password must be less than 20 and more than 8 characters in length.";
            isValid = false;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars)) {
            error = "Password must have atleast one uppercase character.";
            isValid = false;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars)) {
            error = "Password must have atleast one lowercase character.";
            isValid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers)) {
            error = "Password must have atleast one number.";
            isValid = false;
        }
        String specialChars = "(.*[@,#,$,%].*$)";
        if (!password.matches(specialChars)) {
            error = "Password must have atleast one special character among @#$%.";
            isValid = false;
        }
        return isValid;
    }
}
