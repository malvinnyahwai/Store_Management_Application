package com.example.storemanagement.service;

public enum Roles {
    ADMIN("admin"),
    STORE_MANAGER("store_manager"),
    STORE_STAFF("store_staff");

    private final String name;

    Roles(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
