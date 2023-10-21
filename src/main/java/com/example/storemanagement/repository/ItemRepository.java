package com.example.storemanagement.repository;

import com.example.storemanagement.entity.Item;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByName(String name);
    Optional<Item> findByBarCode(String barCode);
    List<Item> findAllByCategory_Id(Long categoryId);
    List<Item> findAllByStore_Id(Long storeId);
    List<Item> findAll(Specification<Item> specification);
}
