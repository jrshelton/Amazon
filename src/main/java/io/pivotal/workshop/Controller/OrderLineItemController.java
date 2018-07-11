package io.pivotal.workshop.Controller;


import io.pivotal.workshop.Model.Order;
import io.pivotal.workshop.Model.OrderLineItem;
import io.pivotal.workshop.Model.Product;
import io.pivotal.workshop.Model.Shipment;
import io.pivotal.workshop.Repository.OrderLineItemRepository;
import io.pivotal.workshop.Repository.OrderRepository;
import io.pivotal.workshop.Repository.ProductRepository;
import io.pivotal.workshop.Repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/orderLineItem")
public class OrderLineItemController {

    @Autowired
    private OrderLineItemRepository orderLineItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;

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

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") long id) {
        orderLineItemRepository.deleteById(id);

    }

    @PutMapping("/edit/{id}")
    public OrderLineItem editById(@PathVariable("id") long id, @RequestBody OrderLineItem orderLineItem) {
        Optional<OrderLineItem> orderLineItemOptional = orderLineItemRepository.findById(id);
        if (!orderLineItemOptional.isPresent()) {
            return null;
        }
        orderLineItem.setOrderLineItemId(id);
        return orderLineItemRepository.save(orderLineItem);

    }

    @PutMapping("/{id}/addProduct/{productId}")
    public Product addProduct(@PathVariable("id") long id, @PathVariable long productId){
        OrderLineItem item = this.findById(id).get();
        Product product = productRepository.findById(productId).get();
        item.setProduct(product);
        this.editById(id, item);

        return product;
    }


    @PutMapping("/{id}/addOrder/{orderId}")
    public Order addOrder(@PathVariable("id") long id, @PathVariable long orderId){

        OrderLineItem item = this.findById(id).get();

        Order order = orderRepository.findById(orderId).get();

        item.setOrder(order);
        order.addLineItem(item);

        editById(id, item);

        return order;

    }


    @PutMapping("/{id}/addShipment/{shipmentId}")
    public Shipment addShipment(@PathVariable("id") long id, @PathVariable long shipmentId){
        OrderLineItem item = this.findById(id).get();

        Shipment shipment = shipmentRepository.findById(shipmentId).get();

        if(item.getOrder() != null){
            shipment.setAccount(item.getOrder().getAccount());
            shipment.setShippingAddressAddress(item.getOrder().getShippingAddress());
        }
        shipment.addLineItems(item);
        shipmentRepository.save(shipment);
        item.setShipment(shipment);
        editById(id, item);
        return shipment;

    }
}