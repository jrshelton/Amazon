package io.pivotal.workshop.Repository;

import io.pivotal.workshop.Model.Account;
import io.pivotal.workshop.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query("Select o FROM Order o WHERE account = :account ORDER BY orderDate")
    Iterable<Order> find(@Param("account") Account account);


}
