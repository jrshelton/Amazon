package io.pivotal.workshop.Controller;


import io.pivotal.workshop.Model.Account;
import io.pivotal.workshop.Model.Address;
import io.pivotal.workshop.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/create")
    public Address createAddress(@Valid @RequestBody Address address){

        return addressRepository.save(address);
    }

    @RequestMapping("/all")
    public Iterable<Address> findAll()
    {
        return addressRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Address> findByID(@PathVariable("id") long id){

        return addressRepository.findById(id);
    }



}