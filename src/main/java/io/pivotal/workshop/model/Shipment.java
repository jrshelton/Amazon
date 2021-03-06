package io.pivotal.workshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @JsonBackReference
    List<OrderLineItem> orderLineItems;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    @ManyToOne
    @JoinColumn(name = "address_id")
    Address ShippingAddress;





    public void addLineItems(OrderLineItem item){
        orderLineItems.add(item);
    }
    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getShippingAddressAddress() {
        return ShippingAddress;
    }

    public void setShippingAddressAddress(Address address) {
        this.ShippingAddress = address;
    }



    public long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(long shipmentId) {
        this.shipmentId = shipmentId;
    }


}
