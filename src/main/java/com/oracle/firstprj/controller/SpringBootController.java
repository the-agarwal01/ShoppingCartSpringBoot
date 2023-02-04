package com.oracle.firstprj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.firstprj.dto.AddCartDTO;
import com.oracle.firstprj.dto.AddOrderDTO;
import com.oracle.firstprj.model.Cart;
import com.oracle.firstprj.model.Item;
import com.oracle.firstprj.model.OrderItem;
import com.oracle.firstprj.model.Person;
import com.oracle.firstprj.repository.CartRepo;
import com.oracle.firstprj.repository.ItemRepo;
import com.oracle.firstprj.repository.OrderRepo;
import java.util.*;

@RestController
public class SpringBootController {

	@Autowired
	OrderRepo ordrepo;
	@Autowired
	CartRepo cartrepo;
	@Autowired
	ItemRepo itemrepo;
	
	
	@GetMapping("/getItemDetails")
	public Iterable<Item> itemDetail()
	{
		Iterable<Item> items = itemrepo.findAll();
		
		return items;
		
	}
	
	
	
	
	
	@PostMapping("/addCart")
	public Cart add(@RequestBody AddCartDTO cartDto)
	{
		Cart ret=new Cart();
		
		Optional<Item> opItem = itemrepo.findById(cartDto.getItemId());
		//Checking if that itemId is present or not
		if(!opItem.isPresent()) {
			System.out.println("Item Not Present");
			return ret;
		}
		Item item = opItem.get();
		
		int qtyToAdd = 0;
		// Getting the minimum of available number of items and item asked for 
		qtyToAdd = Math.min(cartDto.getQty(), item.getItemqty());
		double total = 0;
		total = qtyToAdd*item.getItemprice();
		
		
		Cart cart = new Cart();
		cart.setItemid(cartDto.getItemId());
		cart.setQuantity(qtyToAdd);
		cart.setStatus(null);
		cart.setTotalAmt(total);
		if(item.getItemqty() < cartDto.getQty()) {
			cart.setStatus("Only " + item.getItemqty() + " items were added");
		}else {
			cart.setStatus("Added " + cartDto.getQty() + " items");
		}
		//Adding to cart
		cartrepo.save(cart);
		
		//Removing the added number of items in cart from item table
		item.setItemqty(item.getItemqty()-qtyToAdd);
		itemrepo.save(item);
		
		ret = cart;
		return ret;
	}
	
	@PostMapping("/placeOrder")
	public OrderItem addOrderItem(@RequestBody AddOrderDTO dto)
	{

		int cartId = dto.getCartId();
		OrderItem resp = new OrderItem();
		
		//reading from cart table
		Optional<Cart>opCartObj = cartrepo.findById(cartId);
		if(!opCartObj.isPresent()) {
			System.out.println("No Cart for this Id");
			return resp;
		}
		Cart cartobj = opCartObj.get();
		
		//generating an order object corresponding to this cart
		OrderItem order = new OrderItem(cartId, cartobj.getItemid(), cartobj.getQuantity(), cartobj.getTotalAmt());
		ordrepo.save(order);
		
		//Deleting cart entry from cart table
		cartrepo.deleteById(cartId);
		
		System.out.println(cartobj);
		return order;

	}
	
	
	
}
