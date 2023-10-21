package com.example.storemanagement.web;

import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.dto.StoreDto;
import com.example.storemanagement.repository.dto.StoreFilter;
import com.example.storemanagement.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/store")
public class StoreAPI {

    private StoreService storeService;

    @PostMapping(value = "create")
    public Response<Store> create(@RequestBody StoreDto storeDto) {
        Store store = storeService.create(storeDto);
        return new Response<>(HttpStatus.OK, store, "created successfully");
    }

    @GetMapping(value = "search/{id}")
    public Response<Store> searchById(@PathVariable Long id) {
        Store store = storeService.searchById(id);
        return new Response<>(HttpStatus.OK, store, "found");
    }

    @GetMapping(value = "search")
    public Response<Store> search(@RequestBody StoreFilter storeFilter) {
        Store store = storeService.search(storeFilter);
        return new Response<>(HttpStatus.OK, store, "found");
    }

    @PutMapping(value = "update/{id}")
    public Response<Store> update(@RequestBody StoreDto storeDto, @PathVariable Long id) {
        Store store = storeService.update(storeDto, id);
        return new Response<>(HttpStatus.OK, store, "updated");
    }

    @DeleteMapping(value = "delete/{id}")
    public Response<Store> delete(@PathVariable Long id) {
        storeService.delete(id);
        return new Response<>(HttpStatus.OK, null, "deleted");
    }
}
