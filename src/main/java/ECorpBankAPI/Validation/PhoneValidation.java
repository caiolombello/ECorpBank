package ECorpBankAPI.Validation;

import ECorpBankAPI.Bank.Account;
import ECorpBankAPI.Bank.Client;
import ECorpBankAPI.Bank.PersonType;

public class PhoneValidation extends Client {

    public PhoneValidation(String firstName, String lastName, String document, String email, String phone, String password, PersonType type, Account account) {
        super(firstName, lastName, document, email, phone, password, type, account);
    }

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
