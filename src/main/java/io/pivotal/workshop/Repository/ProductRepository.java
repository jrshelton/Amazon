package io.pivotal.workshop.Repository;

import io.pivotal.workshop.Model.Account;
import io.pivotal.workshop.Model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends CrudRepository<Product, Long> {
}
