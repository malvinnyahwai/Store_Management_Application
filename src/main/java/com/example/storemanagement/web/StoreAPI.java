package com.example.storemanagement.web;

import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.dto.StoreDto;
import com.example.storemanagement.repository.dto.StoreFilter;
import com.example.storemanagement.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/store")
public class StoreAPI {

    private final StoreService storeService;

    public StoreAPI(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping(value = "create")
    @PreAuthorize("hasRole('admin')")
    public Response<Store> create(@RequestBody StoreDto storeDto) {
        Store store = storeService.create(storeDto);
        return new Response<>(HttpStatus.OK, store, "created successfully");
    }

    @GetMapping(value = "search/{id}")
    @PreAuthorize("hasRole('admin') or hasRole('user')")
    public Response<Store> searchById(@PathVariable Long id) {
        Store store = storeService.searchById(id);
        return new Response<>(HttpStatus.OK, store, "found");
    }

    @GetMapping(value = "search")
    @PreAuthorize("hasRole('admin') or hasRole('user')")
    public Response<Store> search(@RequestBody StoreFilter storeFilter) {
        Store store = storeService.search(storeFilter);
        return new Response<>(HttpStatus.OK, store, "found");
    }

    @PutMapping(value = "update/{id}")
    @PreAuthorize("hasRole('admin')")
    public Response<Store> update(@RequestBody StoreDto storeDto, @PathVariable Long id) {
        Store store = storeService.update(storeDto, id);
        return new Response<>(HttpStatus.OK, store, "updated");
    }

    @DeleteMapping(value = "delete/{id}")
    @PreAuthorize("hasRole('admin')")
    public Response<Store> delete(@PathVariable Long id) {
        storeService.delete(id);
        return new Response<>(HttpStatus.OK, null, "deleted");
    }
}
