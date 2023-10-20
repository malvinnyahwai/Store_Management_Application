package com.example.storemanagement.service;

import com.example.storemanagement.entity.Staff;
import com.example.storemanagement.repository.dto.StaffDto;
import com.example.storemanagement.repository.dto.StaffFilter;

import java.util.List;

public interface StaffService {
    Staff create(StaffDto staffDto);
    Staff searchById(Long id);
    List<Staff> search(StaffFilter filter);
    Staff update(StaffDto staffDto);
    void delete(Long id);
}
