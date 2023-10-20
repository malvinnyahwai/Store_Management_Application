package com.example.storemanagement.service;

import com.example.storemanagement.entity.Item;
import com.example.storemanagement.repository.dto.ItemDto;

public interface ItemService {
    Item searchById(Long id);
    Item create(ItemDto itemDto);
}
