package io.pivotal.workshop.repository;

import io.pivotal.workshop.model.OrderLineItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderLineItemRepository  extends CrudRepository<OrderLineItem, Long> {
}
