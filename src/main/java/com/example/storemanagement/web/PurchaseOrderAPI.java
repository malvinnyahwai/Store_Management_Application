package com.example.storemanagement.web;

import com.example.storemanagement.entity.PurchaseOrder;
import com.example.storemanagement.repository.dto.PurchaseOrderDto;
import com.example.storemanagement.repository.dto.PurchaseOrderFilter;
import com.example.storemanagement.service.PurchaseOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/purchase-order")
public class PurchaseOrderAPI {

    private final PurchaseOrderService purchaseOrderService;

    public PurchaseOrderAPI(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @PostMapping(value = "generate")
    public Response<PurchaseOrder> create(@RequestBody PurchaseOrderDto purchaseOrderDto) {
        PurchaseOrder purchaseOrder = purchaseOrderService.generatePurchaseOrder(purchaseOrderDto);
        return new Response<>(HttpStatus.OK, purchaseOrder, "created");
    }

    @GetMapping(value = "search/{id}")
    public Response<PurchaseOrder> searchById(@PathVariable Long id) {
        PurchaseOrder purchaseOrder = purchaseOrderService.searchById(id);
        return new Response<>(HttpStatus.OK, purchaseOrder, "found");
    }

    @GetMapping(value = "search")
    public Response<List<PurchaseOrder>> search(@RequestBody PurchaseOrderFilter purchaseOrderFilter) {
        List<PurchaseOrder> purchaseOrders = purchaseOrderService.search(purchaseOrderFilter);
        return new Response<>(HttpStatus.OK, purchaseOrders, "found");
    }

    @DeleteMapping(value = "delete/{id}")
    public Response<PurchaseOrder> delete(@PathVariable Long id) {
        purchaseOrderService.delete(id);
        return new Response<>(HttpStatus.OK, null, "found");
    }

}
