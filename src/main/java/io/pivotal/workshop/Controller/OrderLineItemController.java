package io.pivotal.workshop.Controller;


import io.pivotal.workshop.Model.Account;
import io.pivotal.workshop.Model.OrderLineItem;
import io.pivotal.workshop.Repository.OrderLineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/orderLineItem")
public class OrderLineItemController {

    @Autowired
    private OrderLineItemRepository orderLineItemRepository;

    @PostMapping("/create")
    public OrderLineItem createOrderLineItem(@Valid @RequestBody OrderLineItem orderLineItem) {

        return orderLineItemRepository.save(orderLineItem);
    }

    @RequestMapping("/all")
    public Iterable<OrderLineItem> findAll() {
        return orderLineItemRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<OrderLineItem> findById(@PathVariable("id") long id) {

        return orderLineItemRepository.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") long id) {
        orderLineItemRepository.deleteById(id);

    }

    @PutMapping("edit/{id}")
    public OrderLineItem editById(@PathVariable("id") long id, @RequestBody OrderLineItem orderLineItem) {
        Optional<OrderLineItem> orderLineItemOptional = orderLineItemRepository.findById(id);
        if (!orderLineItemOptional.isPresent()) {
            return null;
        }
        orderLineItem.setOrderLineItemId(id);
        return orderLineItemRepository.save(orderLineItem);

    }
}