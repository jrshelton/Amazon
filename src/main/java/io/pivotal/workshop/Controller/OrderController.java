package io.pivotal.workshop.Controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import io.pivotal.workshop.Model.*;
import io.pivotal.workshop.Repository.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;


    @PostMapping("/create")
    public Order createAddress(@Valid @RequestBody Order order){

        return orderRepository.save(order);
    }

    @RequestMapping("/all")
    public Iterable<Order> findAll(){
        return orderRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Order> findByID(@PathVariable("id") long id){
        return orderRepository.findById(id);
    }



}