package io.pivotal.workshop.Model;

import javax.persistence.*;

@Entity
public class OrderLineItem {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    long orderLineItemId;
    /*
    //@ManyToOne
    Product product;
    int quantity;
    double price;
    double totalPrice;
    //@OneToOne
    Shipment shipment;
    */
}
