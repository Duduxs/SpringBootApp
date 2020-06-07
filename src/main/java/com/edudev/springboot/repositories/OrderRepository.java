package com.edudev.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edudev.springboot.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
