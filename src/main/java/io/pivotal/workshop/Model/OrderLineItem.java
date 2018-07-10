package io.pivotal.workshop.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "order_line_item")
public class OrderLineItem {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "order_line_item_id")
    long orderLineItemId;

    int quantity;
    double price;
    double totalPrice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    Shipment shipment;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;


}
