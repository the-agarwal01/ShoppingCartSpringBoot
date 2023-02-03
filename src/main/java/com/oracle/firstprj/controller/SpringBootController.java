package com.oracle.firstprj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.firstprj.model.Cart;
import com.oracle.firstprj.model.OrderItem;
import com.oracle.firstprj.model.Person;
import com.oracle.firstprj.repository.CartRepo;
import com.oracle.firstprj.repository.OrderRepo;
import java.util.*;

@RestController
public class SpringBootController {

	@Autowired
	OrderRepo ordrepo;
	@Autowired
	CartRepo cartrepo;
	
	
	
	@PostMapping("/addOrder")
	public String addOrderItem(@RequestBody String cartId)
	{
		
//		
		int cartIdd = Integer.parseInt(cartId);
		Optional<Cart>cartobj = cartrepo.findById(cartIdd);
		System.out.println(cartobj);
		System.out.println(cartId);
		return cartId+"abcd";
//		ordrepo.save(order);
//		return order;
	}
	
//	@PostMapping("/temp")
//	public Cart addPerson(@RequestBody Cart obj)
//	{
//		System.out.println(obj);
//		cartrepo.save(obj);
//		return obj;
//	}
	
	
	
}
