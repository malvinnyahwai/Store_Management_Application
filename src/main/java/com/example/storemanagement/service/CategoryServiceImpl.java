package com.example.storemanagement.service;

import com.example.storemanagement.entity.Category;
import com.example.storemanagement.repository.CategoryRepository;
import com.example.storemanagement.repository.dto.CategoryDto;
import com.example.storemanagement.repository.dto.CategoryFilter;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Category create(CategoryDto categoryDto) {
        Category category = new Category(categoryDto.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category searchById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Category not found..."));
    }

    @Override
    public List<Category> search(CategoryFilter categoryFilter) {
        if(!categoryFilter.getName().isEmpty()) {
            return categoryRepository.findAllByName(categoryFilter.getName());
        } else {
            throw new EntityNotFoundException("Category not found...");
        }
    }

    @Override
    public Category update(CategoryDto categoryDto, Long id) {
        Category category = searchById(id);
        category.setName(category.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
