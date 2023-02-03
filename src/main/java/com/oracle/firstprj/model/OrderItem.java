package com.oracle.firstprj.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderItem {
	@Id
	private int orderId;
	private int cartId;
	private String orderStatus;
	private int itemId;
	private int quantity;
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
	
	
	
}
