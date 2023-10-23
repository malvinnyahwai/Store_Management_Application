package com.example.storemanagement.repository.dto;

import com.example.storemanagement.entity.Address;
import com.example.storemanagement.entity.ContactInformation;
import com.example.storemanagement.entity.StoreType;
import com.sun.istack.NotNull;

import java.util.Date;
import java.util.List;

public class StoreDto {
    @NotNull
    private String name;
    @NotNull
    private Address address;
    private ContactInformation contactInformation;
    private Date creationDate;
    private StoreType storeType;
    private List<Long> staffIds;

    public StoreDto() {

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

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public StoreType getStoreType() {
        return storeType;
    }

    public void setStoreType(StoreType storeType) {
        this.storeType = storeType;
    }

    public List<Long> getStaffIds() {
        return staffIds;
    }

    public void setStaffIds(List<Long> staffIds) {
        this.staffIds = staffIds;
    }
}
