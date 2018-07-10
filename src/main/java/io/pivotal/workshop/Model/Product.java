package io.pivotal.workshop.Model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "product_id")
    long productId;
    String name;
    String description;
    String image;
    double price;
}
