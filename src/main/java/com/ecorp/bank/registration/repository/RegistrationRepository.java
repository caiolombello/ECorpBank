package com.ecorp.bank.registration.repository;

import com.ecorp.bank.appuser.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends CrudRepository<AppUser, String> {

}
