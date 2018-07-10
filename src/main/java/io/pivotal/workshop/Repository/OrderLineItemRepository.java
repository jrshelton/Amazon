package io.pivotal.workshop.Repository;

import io.pivotal.workshop.Model.OrderLineItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderLineItemRepository  extends CrudRepository<OrderLineItem, Long> {
}
