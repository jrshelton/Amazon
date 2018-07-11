package io.pivotal.workshop.Model;

import javafx.util.Pair;

import javax.persistence.Tuple;
import java.util.*;

public class ShippingDetails {
    String orderNumber;
    Date shipmentDate;
    Date deliveryDate;

    Map<String, Integer> productNameQunaity;

    public Map<String, Integer> getProductNameQunaity() {
        return productNameQunaity;
    }



    public ShippingDetails( Date shippmentDate, Date deliveryDate, List<OrderLineItem> lineItems) {
        initOrderNumber(lineItems);
        this.shipmentDate = shippmentDate;
        this.deliveryDate = deliveryDate;
        this.productNameQunaity = initProductNameQuanity(lineItems);

    }

    public void initOrderNumber(List<OrderLineItem> items){
        try {
            this.orderNumber = items.get(0).getOrder().getOrderNumber();
        }catch(IndexOutOfBoundsException e){
            this.orderNumber = "No Orders";
        }
    }

    private Map<String, Integer>  initProductNameQuanity(List<OrderLineItem> lineItems)
    {
        Map<String, Integer> map= new HashMap<>();
        for(OrderLineItem item: lineItems){
            if(item.getProduct()!=null) {
                map.put(item.getProduct().getName(), item.getQuantity());
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
