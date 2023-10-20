package com.example.storemanagement.service;

import com.example.storemanagement.entity.PurchaseOrder;
import com.example.storemanagement.repository.dto.PurchaseOrderDto;

import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrder generatePurchaseOrder(PurchaseOrderDto purchaseOrderDto);
    PurchaseOrder searchById(Long id);
    List<PurchaseOrder> searchByDate();

}
