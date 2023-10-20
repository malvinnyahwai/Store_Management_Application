package com.example.storemanagement.service;

import com.example.storemanagement.entity.Category;
import com.example.storemanagement.repository.dto.CategoryDto;
import com.example.storemanagement.repository.dto.CategoryFilter;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public Category create(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public Category searchById(Long id) {
        return null;
    }

    @Override
    public Category search(CategoryFilter categoryFilter) {
        return null;
    }

    @Override
    public Category update(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
