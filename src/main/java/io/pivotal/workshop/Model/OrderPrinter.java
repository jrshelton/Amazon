package io.pivotal.workshop.Model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrderPrinter {

    String orderNumber;
    Address shippingAddress;
    double totalPrice;
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

    public double getTotPrice() {
        return totalPrice;
    }

    public void setTotPrice(double totPrice) {
        this.totalPrice = totPrice;
    }




}
