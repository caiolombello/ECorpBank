package Validation;

import BankAccount.Client;

public class PhoneValidation extends Client {
    public static boolean isPhone(String phone) {
        try {
            String phoneRegex = "^\\(?(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$";
            return phone.matches(phoneRegex);
        } catch (Exception error) {
            System.err.println("There was an error adding phone: " + error.getMessage());
            return false;
        }
    }
}
