package io.pivotal.workshop.controller;

import io.pivotal.workshop.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import io.pivotal.workshop.model.*;
import io.pivotal.workshop.repository.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OrderController orderController;

    @Autowired
    private ShipmentController shipmentController;

    @Autowired
    private AddressController addressController;

    private AccountService accountService;

    public AccountController(){
        accountService = new AccountService();
    }

    @PostMapping("/create")
    public Account createAccount(@Valid @RequestBody Account account){

        return accountRepository.save(account);
    }

    @RequestMapping("/all")
    public Iterable<Account> findAll(){
        return accountRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Account> findByID(@PathVariable("id") long id){
        return accountRepository.findById(id);
    }



    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") long id){
        accountRepository.deleteById(id);

    }

    @PutMapping("edit/{id}")
    public Account editById(@PathVariable("id") long id, @RequestBody Account account){
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(!accountOptional.isPresent()){
            return null;
        }
        account.setAccountId(id);
        return accountRepository.save(account);

    }

    @GetMapping("/{id}/findOrders")
    public Iterable<Order> findOrders(@PathVariable("id") long id){

        Account account = findByID(id).get();
        return orderController.getAllByOrderDate(account);
    }

    @GetMapping("{id}/orderNumbers")
    public List<String> findOrderNumbers(@PathVariable("id") long id) {
        Account account = findByID(id).get();
        Iterable<Order> orders = orderController.getAllByOrderDate(account);

        return accountService.findOrderNumbers(account, orders);

    }

    @GetMapping("{id}/orderDetails")
    public List<OrderPrinter> findOrderNumbersDetails(@PathVariable("id") long id) {
        Account account = findByID(id).get();
        Iterable<Order> orders = orderController.getAllByOrderDate(account);

        return accountService.findOrderNumbersDetails(account, orders);
    }

    @GetMapping("{id}/shippingDetails")
    public List<ShippingDetails> findShippingDetails(@PathVariable("id") long id){
        Account account = findByID(id).get();
        Iterable<Shipment> shipments = shipmentController.findByAccount(account);
        return accountService.findShippingDetails(account, shipments);
    }

    @PostMapping("{id}/addAddress")
    public Address addAddress(@PathVariable("id") long id, @RequestBody Address address){
        Account account = findByID(id).get();
        address.setAccount(account);
        Address newAddress = addressController.createAddress(address);
        return newAddress;
    }
}
