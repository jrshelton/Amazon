package io.pivotal.workshop.Model;

import javafx.util.Pair;

import javax.persistence.Tuple;
import java.util.*;

public class ShippingDetails {
    String orderNumber;
    Date shipmentDate;
    Date deliveryDate;


    Map<String, Integer> productNameQunaity;

    public ShippingDetails( Date shippmentDate, Date deliveryDate, Set<OrderLineItem> lineItems) {
        this.orderNumber = "ORDERNUMBER";
        this.shipmentDate = shippmentDate;
        this.deliveryDate = deliveryDate;
        this.productNameQunaity = initProductNameQuanity(lineItems);
    }

    private Map<String, Integer>  initProductNameQuanity(Set<OrderLineItem> lineItems)
    {
        Map<String, Integer> map= new HashMap<>();
        for(OrderLineItem item: lineItems){
            String productName = item.getProduct().getName();
            if(map.containsKey(productName)){
                map.put(productName, map.get(productName)+1);
            }
        }
        return map;
    }

    public void setProductNameQunaity(Map<String, Integer> productNameQunaity) {
        this.productNameQunaity = productNameQunaity;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shippmentDate) {
        this.shipmentDate = shippmentDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }




}
