package com.oracle.firstprj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private int cartId;
	private String orderStatus;
	private int itemId;
	private int quantity;
	private double orderAmt;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public OrderItem() {
		
	}
	public OrderItem(int cartId, int itemId, int qty, double total) {
		this.cartId = cartId;
		this.orderStatus="pending";
		this.itemId = itemId;
		this.quantity = qty;
		this.orderAmt = total;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getItemid() {
		return itemId;
	}
	public void setItemid(int itemid) {
		this.itemId = itemid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(double orderAmt) {
		this.orderAmt = orderAmt;
	}
	
	
	
}
