package com.example.storemanagement.entity;

public enum StoreType {
    RETAIL("retail"),
    WAREHOUSE("warehouse");

    private final String name;

    StoreType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
