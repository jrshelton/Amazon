package io.pivotal.workshop.Controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import io.pivotal.workshop.Model.*;
import io.pivotal.workshop.Repository.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/create")
    public Product createAddress(@Valid @RequestBody Product product){

        return productRepository.save(product);
    }

    @RequestMapping("/all")
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Product> findByID(@PathVariable("id") long id){
        return productRepository.findById(id);
    }



}