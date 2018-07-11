package io.pivotal.workshop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrderPrinter {

    String orderNumber;
    Address shippingAddress;
    List<String> productNames;



    Set<OrderLineItem> lineItems;


    public OrderPrinter(String orderNumber, Address shippingAddress, double totPrice,  Set<OrderLineItem> lineItems) {
        this.orderNumber = orderNumber;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totPrice;
        this.lineItems = lineItems;
        this.productNames = getNames(lineItems);
    }

    public List<String> getNames(Set<OrderLineItem> items){
        List<String> names = new ArrayList<>();
        for(OrderLineItem s: items){
            names.add(s.getProduct().getName());
        }
        return names;
    }


    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    double totalPrice;

    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }

    public Set<OrderLineItem> getLineItems() {
        return lineItems;
    }






}
