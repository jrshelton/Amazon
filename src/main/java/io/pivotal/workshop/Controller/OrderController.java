package io.pivotal.workshop.Controller;


import io.pivotal.workshop.Model.Account;
import io.pivotal.workshop.Model.Order;
import io.pivotal.workshop.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/create")
    public Order createOrder(@Valid @RequestBody Order order) {

        return orderRepository.save(order);
    }

    @RequestMapping("/all")
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Order> findById(@PathVariable("id") long id) {

        return orderRepository.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") long id) {
        orderRepository.deleteById(id);

    }

    @PutMapping("edit/{id}")
    public Order editById(@PathVariable("id") long id, @RequestBody Order order) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (!orderOptional.isPresent()) {
            return null;
        }
        order.setId(id);
        return orderRepository.save(order);

    }
}