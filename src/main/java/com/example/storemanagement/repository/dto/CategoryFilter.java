package com.example.storemanagement.repository.dto;

public class CategoryFilter {
    private String name;

    public CategoryFilter() {

    }

    public CategoryFilter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
