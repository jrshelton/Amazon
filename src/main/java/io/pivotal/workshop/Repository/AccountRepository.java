package io.pivotal.workshop.Repository;

import io.pivotal.workshop.Model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public interface AccountRepository extends CrudRepository<Account, Long> {


}
