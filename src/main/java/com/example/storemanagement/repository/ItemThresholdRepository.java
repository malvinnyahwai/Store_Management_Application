package com.example.storemanagement.repository;

import com.example.storemanagement.entity.ItemThreshold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemThresholdRepository extends JpaRepository<ItemThreshold, Long> {
    ItemThreshold findByItem_Id(Long itemId);
}
