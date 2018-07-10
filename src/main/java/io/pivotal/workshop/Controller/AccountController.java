package io.pivotal.workshop.Controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import io.pivotal.workshop.Model.*;
import io.pivotal.workshop.Repository.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;


    @PostMapping("/create")
    public Account createAddress(@Valid @RequestBody Account account){

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



}
