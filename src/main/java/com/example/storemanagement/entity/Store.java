package com.example.storemanagement.entity;

import javax.persistence.*;

@Entity
public class Store {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Embedded
    private Address address;
    private Boolean active;

    public Store() {

    }

    public Store(String name, Address address, Boolean active) {
        this.name = name;
        this.address = address;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
