package com.example.storemanagement.entity;

public enum Country {

    USA("United States of America"),
    UK("United Kingdom"),
    CA("Canada");

    private final String name;

    Country(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
