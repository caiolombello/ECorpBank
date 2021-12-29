package Validation;

import BankAccount.Client;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;

public class DocumentValidation extends Client {

    public static boolean validationCPF(String document) {
        CPFValidator cpfValidator = new CPFValidator();
        try{ cpfValidator.assertValid(document);
            return true;
        }catch(Exception error){
            System.err.println("There was an error adding CPF: " + error.getMessage());
            return false;
        }
    }

    public static boolean validationCNPJ(String document) {
        CNPJValidator cnpjValidator = new CNPJValidator();
        try{ cnpjValidator.assertValid(document);
            return true;
        }catch(Exception error){
            System.err.println("There was an error adding CNPJ: " + error.getMessage());
            return false;
        }
    }
}
