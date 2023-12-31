package com.example.storemanagement.service;

import com.example.storemanagement.entity.Category;
import com.example.storemanagement.entity.Item;
import com.example.storemanagement.entity.ItemThreshold;
import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.ItemRepository;
import com.example.storemanagement.repository.ItemThresholdRepository;
import com.example.storemanagement.repository.dto.ItemDto;
import com.example.storemanagement.repository.dto.ItemFilter;
import com.example.storemanagement.repository.dto.ThresholdDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final CategoryService categoryService;
    private final StoreService storeService;
    private final ItemRepository itemRepository;
    private final ItemThresholdRepository itemThresholdRepository;
    private final NotificationService notificationService;

    public ItemServiceImpl(CategoryService categoryService, StoreService storeService, ItemRepository itemRepository,
                           ItemThresholdRepository itemThresholdRepository, NotificationService notificationService) {
        this.categoryService = categoryService;
        this.storeService = storeService;
        this.itemRepository = itemRepository;
        this.itemThresholdRepository = itemThresholdRepository;
        this.notificationService = notificationService;
    }

    @Override
    public Item create(ItemDto itemDto) {
        Category category = categoryService.searchById(itemDto.getCategoryId());
        Store store = storeService.searchById(itemDto.getStoreId());
        Item item = new Item();
        return itemRepository.save(item);
    }

    @Override
    public Item searchById(Long id) {
        return itemRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Item not found..."));
    }

    @Override
    public List<Item> search(ItemFilter itemFilter) {

        Specification<Item> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (itemFilter.getName() != null) {
                predicates.add(criteriaBuilder.equal(root.get("name"), itemFilter.getName()));
            }

            if (itemFilter.getCategoryId() != null) {
                Category category = categoryService.searchById(itemFilter.getCategoryId());
                predicates.add(criteriaBuilder.equal(root.get("category"), category));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return itemRepository.findAll(spec);
    }

    @Override
    public Item update(ItemDto itemDto, Long id) {
        Item item = searchById(id);
        item.setName(itemDto.getName());
        Category category = categoryService.searchById(itemDto.getCategoryId());
        item.setCategory(category);
        item.setPrice(itemDto.getPrice());
        Store store = storeService.searchById(itemDto.getStoreId());
        item.setStore(store);
        item.setQuantity(itemDto.getQuantity());
        checkThresholdQuantityAndNotifyIfLow(item.getId(), itemDto.getQuantity());
        return itemRepository.save(item);
    }

    private void checkThresholdQuantityAndNotifyIfLow(Long itemId, Long quantity) {
        ItemThreshold itemThreshold = itemThresholdRepository.findByItem_Id(itemId);
        if(itemThreshold.getQuantity() <= quantity) {
            notificationService.notifyManager(itemId, quantity);
        }
    }

    @Override
    public ItemThreshold createItemThreshold(ThresholdDto thresholdDto, Long itemId) {
        Item item = searchById(itemId);
        ItemThreshold itemThreshold = new ItemThreshold(item, thresholdDto.getQuantity());
        return itemThresholdRepository.save(itemThreshold);
    }
    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

}
