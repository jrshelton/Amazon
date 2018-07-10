package io.pivotal.workshop.Repository;

import io.pivotal.workshop.Model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
