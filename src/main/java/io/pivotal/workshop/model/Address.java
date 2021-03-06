package io.pivotal.workshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

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
    @JsonIgnoreProperties({"addresses", "firstName", "lastName", "emailAddress", "hibernateLazyInitializer", "handler"})
    private Account account;

    public Address(){}

}

