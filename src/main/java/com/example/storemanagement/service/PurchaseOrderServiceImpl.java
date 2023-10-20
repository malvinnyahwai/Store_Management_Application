package com.example.storemanagement.service;

import com.example.storemanagement.entity.Item;
import com.example.storemanagement.entity.PurchaseOrder;
import com.example.storemanagement.entity.Staff;
import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.PurchaseOrderRepository;
import com.example.storemanagement.repository.dto.ItemFilter;
import com.example.storemanagement.repository.dto.PurchaseOrderDto;
import com.example.storemanagement.repository.dto.PurchaseOrderFilter;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final StaffService staffService;
    private final ItemService itemService;
    private final StoreService storeService;
    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderServiceImpl(StaffService staffService, ItemService itemService, StoreService storeService,
                                    PurchaseOrderRepository purchaseOrderRepository) {
        this.staffService = staffService;
        this.itemService = itemService;
        this.storeService = storeService;
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    @Override
    public PurchaseOrder generatePurchaseOrder(PurchaseOrderDto purchaseOrderDto) {
        Staff createdBy = staffService.searchById(purchaseOrderDto.getStaffId());
        Store store = storeService.searchById(purchaseOrderDto.getStoreId());
        ItemFilter itemFilter = null;
        List<Item> item = itemService.search(itemFilter);
        PurchaseOrder purchaseOrder = new PurchaseOrder(new Date(), createdBy, store, item, purchaseOrderDto.getAmount());
        return purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public PurchaseOrder searchById(Long id) {
        return purchaseOrderRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("PurchaseOrder not found..."));
    }

    @Override
    public List<PurchaseOrder> search(PurchaseOrderFilter purchaseOrderFilter) {
        return null;
    }

    @Override
    public void delete(Long id) {
        purchaseOrderRepository.deleteById(id);
    }
}
