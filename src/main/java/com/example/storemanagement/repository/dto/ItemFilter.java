package com.example.storemanagement.repository.dto;

import com.example.storemanagement.entity.Category;

import javax.persistence.ManyToOne;

public class ItemFilter {
    private String name;
    private Long categoryId;

    public ItemFilter() {

    }

    public ItemFilter(String name, Long categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
