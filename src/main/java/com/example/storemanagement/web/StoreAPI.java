package com.example.storemanagement.web;

import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.dto.StoreDto;
import com.example.storemanagement.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/store")
public class StoreAPI {

    private StoreService storeService;

    @PostMapping(value = "create")
    public Response<Store> create(@RequestBody StoreDto storeDto) {
        Store store = storeService.create(storeDto);
        return new Response<>(HttpStatus.OK, store, "created successfully");
    }
}
