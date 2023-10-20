package com.example.storemanagement.web;

import com.example.storemanagement.service.StaffService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/staff")
public class StaffAPI {

    private StaffService staffService;
}
