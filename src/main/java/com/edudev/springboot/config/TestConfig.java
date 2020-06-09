package com.edudev.springboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.edudev.springboot.entities.Category;
import com.edudev.springboot.entities.Order;
import com.edudev.springboot.entities.User;
import com.edudev.springboot.entities.enums.OrderStatus;
import com.edudev.springboot.repositories.CategoryRepository;
import com.edudev.springboot.repositories.OrderRepository;
import com.edudev.springboot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User("Edward Oliveira", "Edu123@gmail.com", "(81) 98739-5261", "1239842!ab");
		User u2 = new User("Rachel Youru", "BamandRachel@bol.com", "(81) 4002-8922", "LieAndBetween");

		Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.SHIPPED);
		Order o2 = new Order(Instant.parse("2019-07-22T01:53:07Z"), u1, OrderStatus.PAID);
		Order o3 = new Order(Instant.parse("2019-02-22T06:53:07Z"), u2, OrderStatus.WAITING_PAYMENT);
		
		Category cat1 = new Category ("Eletronics");
		Category cat2 = new Category ("Sports");
		Category cat3 = new Category ("Clothes");

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		

	}

}
