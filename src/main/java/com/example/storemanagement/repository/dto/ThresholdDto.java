package com.example.storemanagement.repository.dto;

public class ThresholdDto {
    private Long id;
    private Long itemId;
    private Long quantity;

    public ThresholdDto() {

    }

    public ThresholdDto(Long itemId, Long quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
