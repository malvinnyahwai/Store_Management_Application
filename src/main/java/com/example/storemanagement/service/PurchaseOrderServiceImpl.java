package com.example.storemanagement.service;

import com.example.storemanagement.entity.PurchaseOrder;
import com.example.storemanagement.repository.dto.PurchaseOrderDto;
import com.example.storemanagement.repository.dto.PurchaseOrderFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService{

    @Override
    public PurchaseOrder generatePurchaseOrder(PurchaseOrderDto purchaseOrderDto) {
        return null;
    }

    @Override
    public PurchaseOrder searchById(Long id) {
        return null;
    }

    @Override
    public List<PurchaseOrder> search(PurchaseOrderFilter purchaseOrderFilter) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
