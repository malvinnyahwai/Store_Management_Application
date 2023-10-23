package com.example.storemanagement.service;

import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.dto.StoreDto;
import com.example.storemanagement.repository.dto.StoreFilter;

public interface StoreService {
    Store create(StoreDto storeDto);
    Store searchById(Long id);
    Store search(StoreFilter storeFilter);
    Store update(StoreDto storeDto, Long id);
    void delete(Long id);
}
