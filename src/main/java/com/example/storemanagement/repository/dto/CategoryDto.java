package com.example.storemanagement.repository.dto;

import com.sun.istack.NotNull;

import java.util.List;

public class CategoryDto {
    @NotNull
    private String name;

    public CategoryDto() {

    }

    public CategoryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
