package io.pivotal.workshop.repository;

import io.pivotal.workshop.model.Account;
import io.pivotal.workshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query("Select o FROM Order o WHERE account = :account ORDER BY orderDate")
    Iterable<Order> find(@Param("account") Account account);


}
