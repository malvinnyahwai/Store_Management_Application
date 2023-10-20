package com.example.storemanagement.web;

import com.example.storemanagement.entity.Category;
import com.example.storemanagement.entity.Item;
import com.example.storemanagement.repository.dto.CategoryDto;
import com.example.storemanagement.repository.dto.ItemDto;
import com.example.storemanagement.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/category")
public class CategoryAPI {

    private CategoryService categoryService;

    @PostMapping(value = "create")
    public Response<Category> create(@RequestBody CategoryDto categoryDto) {
        Category category = categoryService.create(categoryDto);
        return new Response<>(HttpStatus.OK, category, "created successfully");
    }
}
