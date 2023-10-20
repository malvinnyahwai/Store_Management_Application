package com.example.storemanagement.web;

import com.example.storemanagement.entity.Staff;
import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.dto.StaffDto;
import com.example.storemanagement.repository.dto.StoreDto;
import com.example.storemanagement.service.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/staff")
public class StaffAPI {

    private StaffService staffService;

    @PostMapping(value = "create")
    public Response<Staff> create(@RequestBody StaffDto staffDto) {
        Staff staff = staffService.create(staffDto);
        return new Response<>(HttpStatus.OK, staff, "created successfully");
    }
}
