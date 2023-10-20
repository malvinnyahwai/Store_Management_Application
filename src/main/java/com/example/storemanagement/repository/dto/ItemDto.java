package com.example.storemanagement.repository.dto;

import com.sun.istack.NotNull;

import java.util.Date;

public class ItemDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Long categoryId;
    private String barCode;
    private Date sellByDate;
    private Double price;
    private Long storeId;

    public ItemDto() {

    }

    public ItemDto(String name, Long categoryId, String barCode, Date sellByDate, Double price, Long storeId) {
        this.name = name;
        this.categoryId = categoryId;
        this.barCode = barCode;
        this.sellByDate = sellByDate;
        this.price = price;
        this.storeId = storeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Date getSellByDate() {
        return sellByDate;
    }

    public void setSellByDate(Date sellByDate) {
        this.sellByDate = sellByDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
