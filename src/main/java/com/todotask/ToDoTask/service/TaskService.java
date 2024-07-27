package com.todotask.ToDoTask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todotask.ToDoTask.entity.Task;
import com.todotask.ToDoTask.entity.User;
import com.todotask.ToDoTask.repository.TaskRepo;

@Service
public class TaskService {

	@Autowired
	private TaskRepo repo;
	
	public String addTask(Task task) {
		if (repo.addTask(task)) {
			return "Task Inserted Successfully!!";
		} 
		else {
			return "Something Wents wrong!!";
		}
	}
	
	public List<Task> getAllTask() {
		return repo.getAllTask();
	}

	public String deleteTask(int id) {
		if (repo.deleteTask((long)id)) {
			return "Task Deleted Successfully!!";
		} else {
			return "No Task Found While Deleting";
		}
	}
	
	public String updateTask(Task task) {
		if (repo.updateTask(task)) {
			return "Task Updated Successfully!!";
		} else {
			return "No Task Found for Updted";
		}
	}

	public Task getTaskById(int id) {
	  return repo.getTaskById((long) id);
	}
}
