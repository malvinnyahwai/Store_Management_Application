package com.example.storemanagement.repository.dto;

import com.sun.istack.NotNull;

import java.util.List;

public class PurchaseOrderDto {
    @NotNull
    private Long storeId;
    @NotNull
    private List<Long> itemIds;
    private Double amount;

    public PurchaseOrderDto() {

    }

    public PurchaseOrderDto(Long storeId, List<Long> itemIds, Double amount) {
        this.storeId = storeId;
        this.itemIds = itemIds;
        this.amount = amount;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
