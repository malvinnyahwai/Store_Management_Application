package com.example.storemanagement.service;

import com.example.storemanagement.entity.Address;
import com.example.storemanagement.entity.Staff;
import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.StoreRepository;
import com.example.storemanagement.repository.dto.StaffFilter;
import com.example.storemanagement.repository.dto.StoreDto;
import com.example.storemanagement.repository.dto.StoreFilter;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService{

    private final StaffService staffService;
    private final StoreRepository storeRepository;

    public StoreServiceImpl(StaffService staffService, StoreRepository storeRepository) {
        this.staffService = staffService;
        this.storeRepository = storeRepository;
    }

    @Override
    public Store create(StoreDto storeDto) {
        StaffFilter storeFilter = null;
        List<Staff> staff = staffService.search(storeFilter);
        Store store = new Store(storeDto.getName(), storeDto.getAddress(), true, staff);
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
        List<Staff> staff = storeDto.getStaffIds().stream().map(staffService::searchById).collect(Collectors.toList());
        store.setStaff(staff);
        return storeRepository.save(store);
    }

    @Override
    public void delete(Long id) {
        storeRepository.deleteById(id);
    }
}
