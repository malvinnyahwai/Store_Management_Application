package com.example.storemanagement.repository.dto;

import com.example.storemanagement.entity.Address;
import com.sun.istack.NotNull;

import java.util.List;

public class StoreDto {
    @NotNull
    private String name;
    @NotNull
    private Address address;

    private List<Long> staffIds;

    public StoreDto() {

    }

    public StoreDto(String name, Address address, List<Long> staffIds) {
        this.name = name;
        this.address = address;
        this.staffIds = staffIds;
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

    public List<Long> getStaffIds() {
        return staffIds;
    }

    public void setStaffIds(List<Long> staffIds) {
        this.staffIds = staffIds;
    }
}
