package com.example.storemanagement.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "creation_date")
    private Date createdDate;
    @OneToOne
    private Staff createdBy;
    @OneToOne
    private Store store;
    @OneToMany
    private List<Item> item;
    private Double amount;

    public PurchaseOrder() {

    }

    public PurchaseOrder(Date createdDate, Staff createdBy, Store store, List<Item> item, Double amount) {
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.store = store;
        this.item = item;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Staff getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Staff createdBy) {
        this.createdBy = createdBy;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
