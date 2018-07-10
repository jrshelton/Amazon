package io.pivotal.workshop.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "address_id")
    long addressId;
    String street;
    String building;
    String state;
    int zip;
    String country;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}

