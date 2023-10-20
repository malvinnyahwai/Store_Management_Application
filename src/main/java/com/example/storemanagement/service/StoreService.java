package com.example.storemanagement.service;

import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.dto.StoreDto;

import java.util.List;

public interface StoreService {
    Store searchById(Long id);
    Store searchByName(String name);
    Store create(StoreDto storeDto);
    List<Store> create(List<StoreDto> storeDto);
    Store update(StoreDto storeDto);
    void delete(Long id);
}
