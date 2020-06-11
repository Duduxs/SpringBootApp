package com.edudev.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edudev.springboot.entities.User;
import com.edudev.springboot.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	@Autowired
	UserService userService;

	@GetMapping("/find")
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping(value = "/find/{id}")
	public User findById(@PathVariable Long id) {
		return userService.findById(id);
	}

	@PostMapping(value = "/insert")
	public User insert(@RequestBody User user) {
		return userService.insert(user);

	}

	@PutMapping(value = "/update/{id}")
	public void delete(@PathVariable Long id, @RequestBody User user) {
		userService.update(id, user);

	}
}
