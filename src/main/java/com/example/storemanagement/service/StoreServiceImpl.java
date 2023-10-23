package com.example.storemanagement.service;

import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.StoreRepository;
import com.example.storemanagement.repository.dto.StoreDto;
import com.example.storemanagement.repository.dto.StoreFilter;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store create(StoreDto storeDto) {
        Store store = new Store(storeDto.getName(), storeDto.getAddress(), true);
        return storeRepository.save(store);
    }

    @Override
    public Store searchById(Long id) {
        return storeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Store not found..."));
    }

    @Override
    public Store search(StoreFilter storeFilter) {
        if(storeFilter.getName()!=null) {
            return storeRepository.findByName(storeFilter.getName());
        } else {
            throw new EntityNotFoundException("Store not found...");
        }
    }

    @Override
    public Store update(StoreDto storeDto, Long id) {
        Store store = searchById(id);
        store.setName(storeDto.getName());
        store.setAddress(storeDto.getAddress());
        store.setActive(true);
        return storeRepository.save(store);
    }

    @Override
    public void delete(Long id) {
        storeRepository.deleteById(id);
    }
}
