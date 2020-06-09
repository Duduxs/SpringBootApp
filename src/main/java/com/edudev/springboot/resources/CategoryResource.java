package com.edudev.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edudev.springboot.entities.Category;
import com.edudev.springboot.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryResource {
	@Autowired
	CategoryService CategoryService;
	
	@GetMapping("/find")
	public List<Category> findAll() {
		return CategoryService.findAll(); 
	}
	
	@GetMapping(value = "/find/{id}")
	public Category findById(@PathVariable Long id) {
		return CategoryService.findById(id);
	}
}
