package com.edudev.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edudev.springboot.entities.Product;
import com.edudev.springboot.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository ProductRepository;

	public List<Product> findAll() {
		return ProductRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> op = ProductRepository.findById(id);
		return op.get();
	}
}
