package io.pivotal.workshop.model;

import javax.persistence.*;

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
    private Order order;

    public Shipment getShipment(){
       return this.shipment;

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }



    public long getOrderLineItemId() {
        return orderLineItemId;
    }

    public void setOrderLineItemId(long orderLineItemId) {
        this.orderLineItemId = orderLineItemId;
    }




}
