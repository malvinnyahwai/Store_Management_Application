package com.example.storemanagement.repository.dto;

public class ItemFilter {
    private String name;
    private Long categoryId;
    private Double minimumPrice;
    private Double maximumPrice;

    public ItemFilter() {

    }

    public ItemFilter(String name, Long categoryId, Double minimumPrice, Double maximumPrice) {
        this.name = name;
        this.categoryId = categoryId;
        this.minimumPrice = minimumPrice;
        this.maximumPrice = maximumPrice;
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

    public Double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public Double getMaximumPrice() {
        return maximumPrice;
    }

    public void setMaximumPrice(Double maximumPrice) {
        this.maximumPrice = maximumPrice;
    }
}
