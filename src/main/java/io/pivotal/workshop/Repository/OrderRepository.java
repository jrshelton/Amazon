package io.pivotal.workshop.Repository;

import io.pivotal.workshop.Model.Account;
import io.pivotal.workshop.Model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends CrudRepository<Order, Long> {
}
