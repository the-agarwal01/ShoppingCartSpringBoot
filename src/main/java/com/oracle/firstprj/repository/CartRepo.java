package com.oracle.firstprj.repository;

import org.springframework.data.repository.CrudRepository;

import com.oracle.firstprj.model.Cart;

public interface CartRepo extends CrudRepository<Cart,Integer>{

}
