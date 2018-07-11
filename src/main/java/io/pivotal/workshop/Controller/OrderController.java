package io.pivotal.workshop.Controller;


import io.pivotal.workshop.Model.Account;
import io.pivotal.workshop.Model.Order;
import io.pivotal.workshop.Model.OrderLineItem;
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

    @Autowired
    private AccountController accountController;

    @Autowired
    private OrderLineItemController orderLineItemController;

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

    public Iterable<Order> getAllByOrderDate(Account account) {
        return orderRepository.find(account);
    }

    @PutMapping("{id}/addAccount/{accountId}")
    public Account addAccount(@PathVariable("id") long id, @PathVariable("accountId") long accountId){
        Order order = findById(id).get();
        Account account = accountController.findByID(accountId).get();
        order.setAccount(account);
        order.setShippingAddress(account.getAddress().get(0));
        editById(id, order);
        return account;

    }

    @PutMapping("{id}/addLineItem/{itemId}")
    public OrderLineItem addLineItem(@PathVariable("id") long id, @PathVariable("itemId") long itemId){
        Order order = findById(id).get();
        OrderLineItem item = orderLineItemController.findById(itemId).get();
        order.addLineItem(item);
        editById(id, order);
        return item;

    }


}