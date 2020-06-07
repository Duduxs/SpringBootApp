package com.edudev.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edudev.springboot.entities.Order;
import com.edudev.springboot.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> op = orderRepository.findById(id);
		return op.get();
	}
}
