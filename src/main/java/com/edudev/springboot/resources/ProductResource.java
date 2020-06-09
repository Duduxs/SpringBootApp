package com.edudev.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edudev.springboot.entities.Product;
import com.edudev.springboot.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {
	@Autowired
	ProductService ProductService;
	
	@GetMapping("/find")
	public List<Product> findAll() {
		return ProductService.findAll(); 
	}
	
	@GetMapping(value = "/find/{id}")
	public Product findById(@PathVariable Long id) {
		return ProductService.findById(id);
	}
}
