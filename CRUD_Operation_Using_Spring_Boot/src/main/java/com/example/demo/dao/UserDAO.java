package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.AddUser;

public interface UserDAO extends CrudRepository<AddUser, Integer>{

}
