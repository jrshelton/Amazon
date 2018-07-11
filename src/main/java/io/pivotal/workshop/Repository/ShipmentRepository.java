package io.pivotal.workshop.Repository;

import io.pivotal.workshop.Model.Account;
import io.pivotal.workshop.Model.Shipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository  extends CrudRepository<Shipment, Long> {
    @Query("Select s FROM Shipment s WHERE account = :account ")
    Iterable<Shipment> find(@Param("account") Account account);
}