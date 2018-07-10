package io.pivotal.workshop.Controller;


import io.pivotal.workshop.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import io.pivotal.workshop.Model.*;
import io.pivotal.workshop.Repository.*;

import javax.validation.Valid;
import java.io.IOException;
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

    @GetMapping("/orderNumbers/{id}")
    public List<String> findOrderNumbers(@PathVariable("id") long id) throws IOException {
        Iterable<Order> orders = orderController.findAll();
        Account account = findByID(id).get();
        return accountService.findOrderNumbers(account, orders);

    }

    @GetMapping("/orderDetails/{id}")
    public List<OrderPrinter> findOrderNumbersDetails(@PathVariable("id") long id) {
        Iterable<Order> orders = orderController.findAll();
        Account account = findByID(id).get();
        return accountService.findOrderNumbersDetails(account, orders);
    }

    @GetMapping("/shippingDetails/{id}")
    public List<ShippingDetails> findShippingDetails(@PathVariable("id") long id){
        Account account = findByID(id).get();
        Iterable<Shipment> shipments = shipmentController.findAll();
        return accountService.findShippingDetails(account, shipments);
    }
}
