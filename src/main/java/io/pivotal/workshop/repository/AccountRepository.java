package io.pivotal.workshop.repository;

import io.pivotal.workshop.model.Account;
import org.springframework.data.repository.CrudRepository;



public interface AccountRepository extends CrudRepository<Account, Long> {


}
