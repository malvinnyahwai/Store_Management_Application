package com.example.storemanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Store {
    @Id
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Embedded
    private Address address;
    private Boolean active;
    @OneToMany
    private List<Staff> staff;

    public Store() {

    }

    public Store(String name, Address address, Boolean active, List<Staff> staff) {
        this.name = name;
        this.address = address;
        this.active = active;
        this.staff = staff;
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

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }
}
