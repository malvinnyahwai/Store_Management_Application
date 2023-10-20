package com.example.storemanagement.service;

import com.example.storemanagement.entity.Item;
import com.example.storemanagement.repository.dto.ItemDto;
import com.example.storemanagement.repository.dto.ItemFilter;

import java.util.List;

public interface ItemService {
    Item create(ItemDto itemDto);
    Item searchById(Long id);
    List<Item> search(ItemFilter itemFilter);
    Item update(ItemDto itemDto);
    void delete(Long id);
}
