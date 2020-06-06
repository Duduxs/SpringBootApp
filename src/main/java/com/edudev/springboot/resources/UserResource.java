package com.edudev.springboot.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edudev.springboot.entities.User;

@RestController
@RequestMapping("/users")
public class UserResource {

	@GetMapping
	public User selectAll() {
		return new User("Eduardo José", "duduxss3@gmail.com", "(81) 98739-5261", "dudu123");
	}
}
