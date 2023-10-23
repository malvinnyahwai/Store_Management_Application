package com.example.storemanagement.service;

import com.example.storemanagement.entity.Item;
import com.example.storemanagement.entity.ItemThreshold;
import com.example.storemanagement.repository.dto.ItemDto;
import com.example.storemanagement.repository.dto.ItemFilter;
import com.example.storemanagement.repository.dto.ThresholdDto;

import java.util.List;

public interface ItemService {
    Item create(ItemDto itemDto);
    Item searchById(Long id);
    List<Item> search(ItemFilter itemFilter);
    Item update(ItemDto itemDto, Long id);
    void delete(Long id);
    ItemThreshold createItemThreshold(ThresholdDto thresholdDto, Long itemId);
}
