package io.pivotal.workshop.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    long addressId;
    /*
    String street;
    String building;
    String State;
    int zip;
    String Country;
*/
}

