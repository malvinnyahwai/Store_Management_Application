package com.example.storemanagement.repository.dto;

import com.example.storemanagement.entity.Staff;
import com.example.storemanagement.entity.Store;

import javax.persistence.OneToOne;
import java.util.Date;

public class PurchaseOrderFilter {
    private Date createdDate;
    private Long staffId;
    private Long storeId;

    public PurchaseOrderFilter() {

    }

    public PurchaseOrderFilter(Date createdDate, Long staffId, Long storeId) {
        this.createdDate = createdDate;
        this.staffId = staffId;
        this.storeId = storeId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
