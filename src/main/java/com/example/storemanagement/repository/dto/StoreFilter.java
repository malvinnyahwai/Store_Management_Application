package com.example.storemanagement.repository.dto;

public class StoreFilter {
    private String name;

    public StoreFilter() {

    }

    public StoreFilter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
