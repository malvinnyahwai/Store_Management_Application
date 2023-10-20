package com.example.storemanagement.repository.dto;

import com.example.storemanagement.entity.Address;
import com.sun.istack.NotNull;

import java.util.Date;

public class StaffDto {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String idNumber;
    @NotNull
    private Date datOfBirth;
    @NotNull
    private Address address;
    @NotNull
    private Long storeId;

    public StaffDto() {

    }

    public StaffDto(String firstName, String lastName, String idNumber, Date datOfBirth, Address address, Long storeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.datOfBirth = datOfBirth;
        this.address = address;
        this.storeId = storeId;
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

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
