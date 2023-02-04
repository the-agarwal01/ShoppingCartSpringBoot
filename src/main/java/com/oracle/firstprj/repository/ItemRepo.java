package com.oracle.firstprj.repository;
import org.springframework.data.repository.CrudRepository;

import com.oracle.firstprj.model.Item;

public interface ItemRepo extends CrudRepository<Item,Integer>{

}
