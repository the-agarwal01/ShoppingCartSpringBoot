package com.oracle.firstprj.repository;

import org.springframework.data.repository.CrudRepository;

import com.oracle.firstprj.model.Person;

public interface PersonRepo extends CrudRepository<Person,Integer>{

}
