package com.example.storemanagement.service;

import com.example.storemanagement.entity.Item;
import com.example.storemanagement.entity.PurchaseOrder;
import com.example.storemanagement.entity.Staff;
import com.example.storemanagement.entity.Store;
import com.example.storemanagement.repository.PurchaseOrderRepository;
import com.example.storemanagement.repository.dto.PurchaseOrderDto;
import com.example.storemanagement.repository.dto.PurchaseOrderFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Item> item = purchaseOrderDto.getItemIds().stream().map(itemService::searchById).collect(Collectors.toList());
        PurchaseOrder purchaseOrder = new PurchaseOrder(new Date(), createdBy, store, item, purchaseOrderDto.getAmount());
        return purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public PurchaseOrder searchById(Long id) {
        return purchaseOrderRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("PurchaseOrder not found..."));
    }

    @Override
    public List<PurchaseOrder> search(PurchaseOrderFilter purchaseOrderFilter) {


        Specification<PurchaseOrder> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (purchaseOrderFilter.getCreatedDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get("createdDate"), purchaseOrderFilter.getCreatedDate()));
            }

            if (purchaseOrderFilter.getStaffId() != null) {
                Staff staff = staffService.searchById(purchaseOrderFilter.getStaffId());
                predicates.add(criteriaBuilder.equal(root.get("createdBy"), staff));
            }

            if (purchaseOrderFilter.getStoreId() != null) {
                Store store = storeService.searchById(purchaseOrderFilter.getStoreId());
                predicates.add(criteriaBuilder.equal(root.get("store"), store));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return purchaseOrderRepository.findAll(spec);
    }

    @Override
    public void delete(Long id) {
        purchaseOrderRepository.deleteById(id);
    }
}
