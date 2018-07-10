package io.pivotal.workshop.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String orderNumber;
    private String orderDate;
    private double total;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address shippingAddress;

    @OneToMany
    @JoinColumn(name = "line_item_id")
    private Set<OrderLineItem> orderLineItems;
}
