package com.example.storemanagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Item {
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private Category category;
    @Column(name = "bar_code")
    private String barCode;
    @Column(name = "sell_by_date")
    private Date sellByDate;
    private Double price;
    @OneToOne
    private Store store;

    public Item() {

    }

    public Item(String name, Category category, String barCode, Date sellByDate, Double price, Store store) {
        this.name = name;
        this.category = category;
        this.barCode = barCode;
        this.sellByDate = sellByDate;
        this.price = price;
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
