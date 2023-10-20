package com.example.storemanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category {
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToMany
    private List<Item> item;

    public Category() {

    }

    public Category(String name, List<Item> item) {
        this.name = name;
        this.item = item;
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

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
