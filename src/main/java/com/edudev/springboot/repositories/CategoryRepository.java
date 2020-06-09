package com.edudev.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edudev.springboot.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
