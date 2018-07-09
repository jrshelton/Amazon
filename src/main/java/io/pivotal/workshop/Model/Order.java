package io.pivotal.workshop.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Order {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    long orderId;
    /*
    //@ManyToOne
    Account account;
    int orderNumber;
    Date orderDate;
    Address ShippingAddress;
    //@OneToMany
  //  Set<OrderLineItem> orderLineItems;
    double price;
    */
}
