package io.pivotal.workshop.Services;

import io.pivotal.workshop.Controller.AccountController;
import io.pivotal.workshop.Controller.AddressController;
import io.pivotal.workshop.Controller.OrderController;
import io.pivotal.workshop.Controller.ShipmentController;
import io.pivotal.workshop.Model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private OrderController orderController;
    private AccountController accountController;

    @Autowired
    private AddressController addressController;

    public AccountService( ){

    }

    public List<String> findOrderNumbers(Account account, Iterable<Order> orders)  {

        List<String> orderNumbers = new ArrayList<>();
        for(Order order: orders){
            if(order.getAccount().equals(account)){
                orderNumbers.add(order.getOrderNumber());
            }
        }
        return orderNumbers;

    }

    public List<OrderPrinter> findOrderNumbersDetails( Account account, Iterable<Order> orders) {

        List<OrderPrinter> print = new ArrayList<>();
        for (Order order : orders) {
            if (order.getAccount().equals(account)) {
                print.add(new OrderPrinter(order.getOrderNumber(), order.getShippingAddress(), order.getTotal(), order.getOrderLineItems()));
            }
        }
        return print;
    }

    public List<ShippingDetails> findShippingDetails(Account account, Iterable<Shipment> shipments){



        List<ShippingDetails> shippingDetails = new ArrayList<>();

        for(Shipment shipment: shipments){
            if(shipment.getAccount().equals(account)){
                shippingDetails.add(new ShippingDetails(shipment.getShippedDate(), shipment.getDeliveryDate(), shipment.getOrderLineItems()));
            }
        }

        return shippingDetails;
    }


    public Address addAddress(Account account, Address address) {
        address.setAccount(account);
        addressController.createAddress(address);
        return account.addAddress(address);
    }
}
