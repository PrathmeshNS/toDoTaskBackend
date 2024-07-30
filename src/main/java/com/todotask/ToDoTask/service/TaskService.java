package com.todotask.ToDoTask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todotask.ToDoTask.entity.Task;
import com.todotask.ToDoTask.entity.User;
import com.todotask.ToDoTask.repository.TaskRepo;
import com.todotask.ToDoTask.utility.PredefineTaskString;

@Service
public class TaskService {

	@Autowired
	private TaskRepo repo;
	
	public String addTask(Task task) {
		if (repo.addTask(task)) {
			return PredefineTaskString.TASK_INSERTED_SUCCESSFULLY;
		} 
		else {
			return PredefineTaskString.ERROR_MESSAGE;
		}
	}
	
	public String deleteTask(int id) {
		if (repo.deleteTask((long)id)) {
			return PredefineTaskString.TASK_DELETE ;
		} else {
			return PredefineTaskString.TASK_DELETE_ERROR_MESSAGE ;
		}
	}
	
	public String updateTask(Task task) {
		if (repo.updateTask(task)) {
			return PredefineTaskString.TASK_UPDATED;
		} else {
			return PredefineTaskString.TASK_UPDATED_ERROR_MESSAGE;
		}
	}

	public Task getTaskById(int id) {
	  return repo.getTaskById((long) id);
	}
}
