package com.oracle.firstprj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.oracle.firstprj.repository.ItemRepo;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartid;
	private int itemid;
	private int quantity;
	private String status;
	private double totalamt;
	
	public int getCid() {
		return cartid;
	}
	public void setCid(int cid) {
		this.cartid = cid;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Cart [cid=" + cartid + ", itemid=" + itemid + ", quantity=" + quantity + ", status=" + status + "]";
	}
	
	public double getTotalAmt() {
		return totalamt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalamt = totalAmt;
	}
	
	
	
	
	
	
}
