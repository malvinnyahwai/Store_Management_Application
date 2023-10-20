package com.example.storemanagement.service;

import com.example.storemanagement.entity.PurchaseOrder;
import com.example.storemanagement.repository.dto.PurchaseOrderDto;
import com.example.storemanagement.repository.dto.PurchaseOrderFilter;

import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrder generatePurchaseOrder(PurchaseOrderDto purchaseOrderDto);
    PurchaseOrder searchById(Long id);
    List<PurchaseOrder> search(PurchaseOrderFilter purchaseOrderFilter);
    void delete(Long id);
}
