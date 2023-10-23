package com.example.storemanagement.web;

import com.example.storemanagement.entity.Category;
import com.example.storemanagement.repository.dto.CategoryDto;
import com.example.storemanagement.repository.dto.CategoryFilter;
import com.example.storemanagement.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryAPI {

    private final CategoryService categoryService;

    public CategoryAPI(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "create")
    @PreAuthorize("hasRole('admin')")
    public Response<Category> create(@RequestBody CategoryDto categoryDto) {
        Category category = categoryService.create(categoryDto);
        return new Response<>(HttpStatus.OK, category, "created");
    }

    @GetMapping(value = "search/{id}")
    @PreAuthorize("hasRole('admin')")
    public Response<Category> searchById(@PathVariable Long id) {
        Category category = categoryService.searchById(id);
        return new Response<>(HttpStatus.OK, category, "found");
    }

    @GetMapping(value = "search")
    @PreAuthorize("hasRole('admin')")
    public Response<List<Category>> search(@RequestBody CategoryFilter categoryFilter) {
        List<Category> categories = categoryService.search(categoryFilter);
        return new Response<>(HttpStatus.OK, categories, "found");
    }

    @PutMapping(value = "update/{id}")
    @PreAuthorize("hasRole('admin')")
    public Response<Category> update(@RequestBody CategoryDto categoryDto, @PathVariable Long id) {
        Category category = categoryService.update(categoryDto, id);
        return new Response<>(HttpStatus.OK, category, "updated");
    }

    @DeleteMapping(value = "delete/{id}")
    @PreAuthorize("hasRole('admin')")
    public Response<Category> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return new Response<>(HttpStatus.OK, null, "deleted");
    }
}
