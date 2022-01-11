package com.ecorp.bank.registration.validators;

import br.com.caelum.stella.validation.CPFValidator;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class CpfValidator implements Predicate<String> {
    @Override
    public boolean test(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
            return true;
        } catch (Exception error) {
            System.err.println("There was an error adding CPF: " + error.getMessage());
            return false;
        }
    }

}
