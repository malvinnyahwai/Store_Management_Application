package com.example.storemanagement.service;

import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.dto.StoreDto;
import com.example.storemanagement.repository.dto.StoreFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{

    @Override
    public Store create(StoreDto storeDto) {
        return null;
    }

    @Override
    public Store searchById(Long id) {
        return null;
    }

    @Override
    public Store search(StoreFilter storeFilter) {
        return null;
    }

    @Override
    public Store update(StoreDto storeDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
