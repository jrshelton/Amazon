package io.pivotal.workshop.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.pivotal.workshop.Model.*;
import io.pivotal.workshop.Repository.*;

import java.util.List;


@RestController
@RequestMapping("/contacts")
public class AccountController {


    private final AccountRepository accountRepository;


    public AccountController(){
        this.accountRepository = new AccountRepository();
    }

    @RequestMapping("/")
    public ResponseEntity<?> home(){
        return ResponseEntity.ok().body("This is working");
    }
/*
    @PostMapping("/account")
    public ResponseEntity<?> addAccount(@RequestBody Account account){
        long id = accountRepository.save(account);
        return ResponseEntity.ok().body("New Account has been saved with ID:" + id);
    }


    @GetMapping("/account/show")
    public List<Account> list(){
        return AccountRepository.list();

    }*/
}
