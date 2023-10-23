package com.example.storemanagement.repository.dto;

import com.example.storemanagement.entity.StoreType;

import java.util.Date;

public class StoreFilter {
    private String name;
    private String location;
    private StoreType storeType;
    private Date openingDate;

    public StoreFilter() {

    }

    public StoreFilter(String name, String location, StoreType storeType, Date openingDate) {
        this.name = name;
        this.location = location;
        this.storeType = storeType;
        this.openingDate = openingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public StoreType getStoreType() {
        return storeType;
    }

    public void setStoreType(StoreType storeType) {
        this.storeType = storeType;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }
}
