package com.example.groceryapi.repository;

import com.example.groceryapi.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {}
public interface OrderRepository extends JpaRepository<Order, Long> {}