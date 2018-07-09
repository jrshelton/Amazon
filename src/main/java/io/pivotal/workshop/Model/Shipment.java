package io.pivotal.workshop.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Shipment {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    long shipmentId;/*
    Account account;
    Address address;
    //@OneToMany
    //Set<OrderLineItem> orderLineItems;
    Date shippedDate;
    Date deliveryDate;*/
}
