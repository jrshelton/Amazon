package io.pivotal.workshop.Repository;

import io.pivotal.workshop.Model.Shipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository  extends CrudRepository<Shipment, Long> {
}