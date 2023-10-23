package com.example.storemanagement.entity;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private Category category;
    private String description;
    private Double price;
    @OneToOne
    private Store store;
    @Column(name = "initial_quantity")
    private Long initialQuantity;
    private Long quantity;
    @ManyToOne
    private Supplier supplier;

    public Item() {

    }

    public Item(String name, Category category, String description, Double price, Store store, Long initialQuantity,
                Long quantity, Supplier supplier) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.store = store;
        this.initialQuantity = initialQuantity;
        this.quantity = quantity;
        this.supplier = supplier;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(Long initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
