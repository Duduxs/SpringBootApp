package com.edudev.springboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.edudev.springboot.entities.Category;
import com.edudev.springboot.entities.Order;
import com.edudev.springboot.entities.OrderItem;
import com.edudev.springboot.entities.Payment;
import com.edudev.springboot.entities.Product;
import com.edudev.springboot.entities.User;
import com.edudev.springboot.entities.enums.OrderStatus;
import com.edudev.springboot.repositories.CategoryRepository;
import com.edudev.springboot.repositories.OrderItemRepository;
import com.edudev.springboot.repositories.OrderRepository;
import com.edudev.springboot.repositories.ProductRepository;
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

	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User("Edward Oliveira", "Edu123@gmail.com", "(81) 98739-5261", "1239842!ab");
		User u2 = new User("Rachel Youru", "BamandRachel@bol.com", "(81) 4002-8922", "LieAndBetween");


		Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.SHIPPED);
		Order o2 = new Order(Instant.parse("2019-07-22T01:53:07Z"), u1, OrderStatus.PAID);
		Order o3 = new Order(Instant.parse("2019-02-22T06:53:07Z"), u2, OrderStatus.WAITING_PAYMENT);

		Category cat1 = new Category("Eletronics");
		Category cat2 = new Category("Sports");
		Category cat3 = new Category("Clothes");

		Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		Payment pay1 = new Payment(Instant.parse("2020-10-06T20:02:07Z"), o1);
		Payment pay2 = new Payment(Instant.parse("2020-05-04T12:30:04Z"), o2);
		Payment pay3 = new Payment(Instant.parse("2010-10-23T06:24:05Z"), o3);

		o1.setPayment(pay1);
		o2.setPayment(pay2);
		o3.setPayment(pay3);

		p1.getCategories().add(cat2);
		p2.getCategories().addAll(Arrays.asList(cat1, cat3));
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

	}

}
