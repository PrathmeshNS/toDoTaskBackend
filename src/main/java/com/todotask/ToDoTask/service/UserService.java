package com.todotask.ToDoTask.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todotask.ToDoTask.encrypt.EncryptPassword;
import com.todotask.ToDoTask.entity.User;
import com.todotask.ToDoTask.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	@Autowired
	EncryptPassword encryptPassword;
	
	Logger LOGGER = LoggerFactory.getLogger(getClass());

	public String addUser(User user) {
		user.setPassword(encryptPassword.convertToMD5(user.getPassword()));
		if (repository.searchByEmail(user.getEmail()) == null) {
			if (repository.addUser(user)) {
				return " User Inserted Successfully!!";
			} 
		} else {
			return "Email Already Exits";
		}
		return "Somethings Wents Wrong";
	}

	public User checkUser(User user) {
		User user1 = repository.searchByEmail(user.getEmail());
		user.setPassword(encryptPassword.convertToMD5(user.getPassword()));
		LOGGER.warn("At Check User BEfore If");
		if (user1 !=null) {
			if ((user1.getEmail().equals(user.getEmail()))&& (user1.getPassword().equals(user.getPassword()))) {
				LOGGER.warn("At Check User BEfore return the value");
				return user1;
			}
		}
			return null; 
	}

	public User getUserById(int id) {
		return repository.getUserById(id);
	}

}
