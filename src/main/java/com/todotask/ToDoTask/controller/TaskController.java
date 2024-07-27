package com.todotask.ToDoTask.controller;

import org.springframework.web.bind.annotation.RestController;

import com.todotask.ToDoTask.entity.Task;
import com.todotask.ToDoTask.service.TaskService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	TaskService  service;
	
//	@GetMapping("")
//	public List<Task> getTask() {
//		return service.getAllTask();
//		
//	}
//	

	@GetMapping("/byId/{id}")
	public Task getTaskById(@PathVariable("id") String id) {
		return service.getTaskById(Integer.parseInt(id));
	}
	
	@PostMapping("/insert")
	public String addTask(@RequestBody Task	task) {
		return service.addTask(task);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteTask(@PathVariable String id) {	
		return service.deleteTask(Integer.parseInt(id));
	}

	
	@PostMapping("/update")
	public String updateTask(@RequestBody Task task) {	
		return service.updateTask(task);
	}
	
}
