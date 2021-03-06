package io.pivotal.workshop.controller;


import io.pivotal.workshop.model.Address;
import io.pivotal.workshop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/create")
    public Address createAddress(@RequestBody Address address){

        return addressRepository.save(address);
    }

    @RequestMapping("/all")
    public Iterable<Address> findAll()
    {
        return addressRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Address> findById(@PathVariable("id") long id){

        return addressRepository.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") long id){
         addressRepository.deleteById(id);

    }

    @PutMapping("edit/{id}")
    public Address editById(@PathVariable("id") long id, @RequestBody Address address){
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(!addressOptional.isPresent()){
            return null;
        }
        address.setAddressId(id);
        return addressRepository.save(address);

    }



}
