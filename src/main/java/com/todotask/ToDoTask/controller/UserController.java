package com.todotask.ToDoTask.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todotask.ToDoTask.entity.User;
import com.todotask.ToDoTask.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@PostMapping("/checkUser")
	public User checkUser(@RequestBody User user) {
		return userService.checkUser(user);
	}

	@GetMapping("/byId/{id}")
	public User getTaskById(@PathVariable("id") String id) {
		return userService.getUserById(Integer.parseInt(id));
	}
}
