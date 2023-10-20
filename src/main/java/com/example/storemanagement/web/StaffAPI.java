package com.example.storemanagement.web;

import com.example.storemanagement.entity.Staff;
import com.example.storemanagement.repository.dto.StaffDto;
import com.example.storemanagement.repository.dto.StaffFilter;
import com.example.storemanagement.service.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/staff")
public class StaffAPI {

    private final StaffService staffService;

    public StaffAPI(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping(value = "create")
    public Response<Staff> create(@RequestBody StaffDto staffDto) {
        Staff staff = staffService.create(staffDto);
        return new Response<>(HttpStatus.OK, staff, "created");
    }

    @GetMapping(value = "search/{id}")
    public Response<Staff> searchById(@PathVariable Long id) {
        Staff staff = staffService.searchById(id);
        return new Response<>(HttpStatus.OK, staff, "found");
    }

    @GetMapping(value = "search")
    public Response<List<Staff>> search(@RequestBody StaffFilter filter) {
        List<Staff> staff = staffService.search(filter);
        return new Response<>(HttpStatus.OK, staff, "found");
    }

    @PutMapping(value = "update/{id}")
    public Response<Staff> update(@RequestBody StaffDto staffDto, @PathVariable Long id) {
        Staff staff = staffService.update(staffDto, id);
        return new Response<>(HttpStatus.OK, staff, "updated");
    }

    @DeleteMapping(value = "delete/{id}")
    public Response<Staff> delete(Long id) {
        staffService.delete(id);
        return new Response<>(HttpStatus.OK, null, "updated");
    }
}
