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
        if(filter.getIdNumber()!=null) {
            return staffRepository.findAllByIdNumber(filter.getIdNumber());
        } else {
            throw new EntityNotFoundException("Staff not found...");
        }
    }

    @Override
    public Staff update(StaffDto staffDto, Long id) {
        Staff staff = searchById(id);
        staff.setFirstName(staffDto.getFirstName());
        staff.setLastName(staffDto.getLastName());
        staff.setIdNumber(staffDto.getIdNumber());
        staff.setDatOfBirth(staffDto.getDatOfBirth());
        staff.setAddress(staffDto.getAddress());
        Store store = storeService.searchById(staffDto.getStoreId());
        staff.setStore(store);
        staff.setActive(true);
        return staffRepository.save(staff);
    }

    @Override
    public void delete(Long id) {
        staffRepository.deleteById(id);
    }
}
