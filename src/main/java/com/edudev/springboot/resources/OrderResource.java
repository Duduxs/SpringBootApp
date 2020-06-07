package com.edudev.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edudev.springboot.entities.Order;
import com.edudev.springboot.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderResource {
	@Autowired
	OrderService orderService;
	
	@GetMapping("/find")
	public List<Order> findAll() {
		return orderService.findAll(); 
	}
	
	@GetMapping(value = "/find/{id}")
	public Order findById(@PathVariable Long id) {
		return orderService.findById(id);
	}
}
