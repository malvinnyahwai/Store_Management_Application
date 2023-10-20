package com.example.storemanagement.web;

import com.example.storemanagement.entity.PurchaseOrder;
import com.example.storemanagement.repository.dto.PurchaseOrderDto;
import com.example.storemanagement.service.PurchaseOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/purchase-order")
public class PurchaseOrderAPI {

    private PurchaseOrderService purchaseOrderService;

    @PostMapping(value = "generate")
    public Response<PurchaseOrder> create(@RequestBody PurchaseOrderDto purchaseOrderDto) {
        PurchaseOrder purchaseOrder = purchaseOrderService.generatePurchaseOrder(purchaseOrderDto);
        return new Response<>(HttpStatus.OK, purchaseOrder, "created successfully");
    }
}
