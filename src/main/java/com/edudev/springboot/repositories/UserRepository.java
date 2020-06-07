package com.edudev.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edudev.springboot.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
