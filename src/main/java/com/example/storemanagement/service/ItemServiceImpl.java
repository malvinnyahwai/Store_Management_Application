package com.example.storemanagement.service;

import com.example.storemanagement.entity.Category;
import com.example.storemanagement.entity.Item;
import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.ItemRepository;
import com.example.storemanagement.repository.dto.ItemDto;
import com.example.storemanagement.repository.dto.ItemFilter;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final CategoryService categoryService;
    private final StoreService storeService;
    private final ItemRepository itemRepository;

    public ItemServiceImpl(CategoryService categoryService, StoreService storeService, ItemRepository itemRepository) {
        this.categoryService = categoryService;
        this.storeService = storeService;
        this.itemRepository = itemRepository;
    }

    @Override
    public Item create(ItemDto itemDto) {
        Category category = categoryService.searchById(itemDto.getCategoryId());
        Store store = storeService.searchById(itemDto.getStoreId());
        Item item = new Item(itemDto.getName(), category, itemDto.getBarCode(), itemDto.getSellByDate(),
                itemDto.getPrice(), store);
        return itemRepository.save(item);
    }

    @Override
    public Item searchById(Long id) {
        return itemRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Item not found..."));
    }

    @Override
    public List<Item> search(ItemFilter itemFilter) {
        return null;
    }

    @Override
    public Item update(ItemDto itemDto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

}
