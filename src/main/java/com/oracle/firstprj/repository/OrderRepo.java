package com.oracle.firstprj.repository;

import org.springframework.data.repository.CrudRepository;

import com.oracle.firstprj.model.OrderItem;

public interface OrderRepo extends CrudRepository<OrderItem,Integer>{

}
