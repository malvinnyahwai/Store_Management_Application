package com.example.storemanagement.service;

import com.example.storemanagement.entity.Category;
import com.example.storemanagement.repository.dto.CategoryDto;
import com.example.storemanagement.repository.dto.CategoryFilter;

public interface CategoryService {
    Category create(CategoryDto categoryDto);
    Category searchById(Long id);
    Category search(CategoryFilter categoryFilter);
    Category update(CategoryDto categoryDto);
    void delete(Long id);
}
