package com.example.storemanagement.web;

import com.example.storemanagement.entity.Item;
import com.example.storemanagement.repository.dto.ItemDto;
import com.example.storemanagement.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/item")
public class ItemAPI {

    private ItemService itemService;

    @PostMapping(value = "create")
    public Response<Item> create(@RequestBody ItemDto itemDto) {
        Item item = itemService.create(itemDto);
        return new Response<>(HttpStatus.OK, item, "created successfully");
    }
}
