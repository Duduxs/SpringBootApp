package com.edudev.springboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.edudev.springboot.entities.User;
import com.edudev.springboot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User("Edward Oliveira","Edu123@gmail.com","(81) 98739-5261", "1239842!ab");
		User u2 = new User("Rachel Youru","BamandRachel@bol.com","(81) 4002-8922", "LieAndBetween");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		
	}
	
	
}
