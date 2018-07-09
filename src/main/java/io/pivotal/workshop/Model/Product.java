package io.pivotal.workshop.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    long productId;/*
    String Name;
    String description;
    String image; // todo: Check this type
    double price;*/
}
