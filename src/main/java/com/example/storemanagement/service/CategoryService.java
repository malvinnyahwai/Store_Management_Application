package com.example.storemanagement.service;

import com.example.storemanagement.entity.Category;
import com.example.storemanagement.repository.dto.CategoryDto;
import com.example.storemanagement.repository.dto.CategoryFilter;

import java.util.List;

public interface CategoryService {
    Category create(CategoryDto categoryDto);
    Category searchById(Long id);
    List<Category> search(CategoryFilter categoryFilter);
    Category update(CategoryDto categoryDto, Long id);
    void delete(Long id);
}
