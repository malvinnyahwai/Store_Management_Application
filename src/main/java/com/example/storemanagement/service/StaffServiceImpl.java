package com.example.storemanagement.service;

import com.example.storemanagement.entity.Staff;
import com.example.storemanagement.repository.dto.StaffDto;
import com.example.storemanagement.repository.dto.StaffFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Override
    public Staff create(StaffDto staffDto) {
        return null;
    }

    @Override
    public Staff searchById(Long id) {
        return null;
    }

    @Override
    public List<Staff> search(StaffFilter filter) {
        return null;
    }

    @Override
    public Staff update(StaffDto staffDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
