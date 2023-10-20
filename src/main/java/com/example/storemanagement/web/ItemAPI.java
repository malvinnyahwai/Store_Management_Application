package com.example.storemanagement.web;

import com.example.storemanagement.entity.Item;
import com.example.storemanagement.repository.dto.ItemDto;
import com.example.storemanagement.repository.dto.ItemFilter;
import com.example.storemanagement.service.ItemService;
import org.springframework.http.HttpStatus;
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
    public Response<Item> create(@RequestBody ItemDto itemDto) {
        Item item = itemService.create(itemDto);
        return new Response<>(HttpStatus.OK, item, "created");
    }

    @GetMapping(value = "search/{id}")
    public Response<Item> searchById(@PathVariable Long id) {
        Item item = itemService.searchById(id);
        return new Response<>(HttpStatus.OK, item, "found");
    }

    @GetMapping(value = "search")
    public Response<List<Item>> search(@RequestBody ItemFilter itemFilter) {
        List<Item> item = itemService.search(itemFilter);
        return new Response<>(HttpStatus.OK, item, "found");
    }

    @PutMapping(value = "update/{id}")
    public Response<Item> update(@RequestBody ItemDto itemDto, @PathVariable Long id) {
        Item item = itemService.update(itemDto, id);
        return new Response<>(HttpStatus.OK, item, "updated");
    }

    @DeleteMapping(value = "delete/{id}")
    public Response<Item> delete(@PathVariable Long id) {
        itemService.delete(id);
        return new Response<>(HttpStatus.OK, null, "deleted");
    }
}
