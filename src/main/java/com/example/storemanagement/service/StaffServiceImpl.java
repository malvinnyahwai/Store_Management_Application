package com.example.storemanagement.service;

import com.example.storemanagement.entity.Staff;
import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.StaffRepository;
import com.example.storemanagement.repository.dto.StaffDto;
import com.example.storemanagement.repository.dto.StaffFilter;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    private final StoreService storeService;
    private final StaffRepository staffRepository;

    public StaffServiceImpl(StoreService storeService, StaffRepository staffRepository) {
        this.storeService = storeService;
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff create(StaffDto staffDto) {
        Store store = storeService.searchById(staffDto.getStoreId());
        Staff staff = new Staff(staffDto.getFirstName(), staffDto.getLastName(), staffDto.getIdNumber(), staffDto.getDatOfBirth(),
                staffDto.getAddress(), store, true);
        return staffRepository.save(staff);
    }

    @Override
    public Staff searchById(Long id) {
        return staffRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Staff not found..."));
    }

    @Override
    public List<Staff> search(StaffFilter filter) {
        return null;
    }

    @Override
    public Staff update(StaffDto staffDto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        staffRepository.deleteById(id);
    }
}
