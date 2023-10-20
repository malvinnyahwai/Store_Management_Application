package com.example.storemanagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Staff {
    @Id
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "date_of_birth")
    private Date datOfBirth;
    @Embedded
    private Address address;
    @ManyToOne
    private Store store;
    private Boolean active;

    public Staff() {

    }

    public Staff(String firstName, String lastName, String idNumber, Date datOfBirth, Address address, Store store,
                 Boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.datOfBirth = datOfBirth;
        this.address = address;
        this.store = store;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getDatOfBirth() {
        return datOfBirth;
    }

    public void setDatOfBirth(Date datOfBirth) {
        this.datOfBirth = datOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
