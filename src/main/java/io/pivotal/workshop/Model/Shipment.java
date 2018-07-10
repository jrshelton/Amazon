package io.pivotal.workshop.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "shipment")
public class Shipment {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "shipment_id")
    long shipmentId;

    Date shippedDate;
    Date deliveryDate;

    @OneToMany
    @JoinColumn(name = "shipment_id")
    @JsonIgnore
    Set<OrderLineItem> orderLineItems;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;

}
