package com.example.storemanagement.repository.dto;

import com.sun.istack.NotNull;

import java.util.List;

public class CategoryDto {
    @NotNull
    private String name;
    private List<Long> itemIds;

    public CategoryDto() {

    }

    public CategoryDto(String name, List<Long> itemIds) {
        this.name = name;
        this.itemIds = itemIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }
}
