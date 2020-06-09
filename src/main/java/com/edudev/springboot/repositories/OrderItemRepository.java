package com.edudev.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edudev.springboot.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
