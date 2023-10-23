package com.example.storemanagement.web;

import com.example.storemanagement.entity.Item;
import com.example.storemanagement.entity.ItemThreshold;
import com.example.storemanagement.repository.dto.ItemDto;
import com.example.storemanagement.repository.dto.ItemFilter;
import com.example.storemanagement.repository.dto.ThresholdDto;
import com.example.storemanagement.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/item")
public class ItemAPI {

    private final ItemService itemService;

    public ItemAPI(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(value = "create")
    @PreAuthorize("hasRole('store_manager')")
    public Response<Item> create(@RequestBody ItemDto itemDto) {
        Item item = itemService.create(itemDto);
        return new Response<>(HttpStatus.OK, item, "created");
    }

    @GetMapping(value = "search/{id}")
    @PreAuthorize("hasRole('store_manager')")
    public Response<Item> searchById(@PathVariable Long id) {
        Item item = itemService.searchById(id);
        return new Response<>(HttpStatus.OK, item, "found");
    }

    @GetMapping(value = "search")
    @PreAuthorize("hasRole('store_manager')")
    public Response<List<Item>> search(@RequestBody ItemFilter itemFilter) {
        List<Item> item = itemService.search(itemFilter);
        return new Response<>(HttpStatus.OK, item, "found");
    }

    @PutMapping(value = "update/{id}")
    @PreAuthorize("hasRole('store_manager')")
    public Response<Item> update(@RequestBody ItemDto itemDto, @PathVariable Long id) {
        Item item = itemService.update(itemDto, id);
        return new Response<>(HttpStatus.OK, item, "updated");
    }

    @PostMapping(value = "threshold/{itemId}")
    @PreAuthorize("hasRole('store_manager')")
    public Response<ItemThreshold> createThreshold(@RequestBody ThresholdDto thresholdDto, @PathVariable Long itemId) {
        ItemThreshold itemThreshold = itemService.createItemThreshold(thresholdDto, itemId);
        return new Response<>(HttpStatus.OK, itemThreshold, "created");
    }

    @DeleteMapping(value = "delete/{id}")
    @PreAuthorize("hasRole('store_manager')")
    public Response<Item> delete(@PathVariable Long id) {
        itemService.delete(id);
        return new Response<>(HttpStatus.OK, null, "deleted");
    }
}
