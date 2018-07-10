package io.pivotal.workshop.Repository;

import io.pivotal.workshop.Model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
