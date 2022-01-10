package com.ecorp.bank.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String cpf;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String password;
}
