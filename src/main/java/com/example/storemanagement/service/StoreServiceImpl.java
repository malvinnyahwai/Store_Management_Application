package com.example.storemanagement.service;

import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.dto.StoreDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{
    @Override
    public Store searchById(Long id) {
        return null;
    }

    @Override
    public Store searchByName(String name) {
        return null;
    }

    @Override
    public Store create(StoreDto storeDto) {
        return null;
    }

    @Override
    public List<Store> create(List<StoreDto> storeDto) {
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
