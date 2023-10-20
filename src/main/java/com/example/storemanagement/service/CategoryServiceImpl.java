package com.example.storemanagement.service;

import com.example.storemanagement.entity.Category;
import com.example.storemanagement.entity.Item;
import com.example.storemanagement.repository.CategoryRepository;
import com.example.storemanagement.repository.dto.CategoryDto;
import com.example.storemanagement.repository.dto.CategoryFilter;
import com.example.storemanagement.repository.dto.ItemFilter;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final ItemService itemService;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(ItemService itemService, CategoryRepository categoryRepository) {
        this.itemService = itemService;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Category create(CategoryDto categoryDto) {
        ItemFilter itemFilter = null;
        List<Item> itemList = itemService.search(itemFilter);
        Category category = new Category(categoryDto.getName(), itemList);
        return categoryRepository.save(category);
    }

    @Override
    public Category searchById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Category not found..."));
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
        categoryRepository.deleteById(id);
    }
}
