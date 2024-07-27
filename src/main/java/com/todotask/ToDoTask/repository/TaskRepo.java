package com.todotask.ToDoTask.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todotask.ToDoTask.entity.Task;
import com.todotask.ToDoTask.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

@Repository
public class TaskRepo {
	
	Logger LOGGER =  LoggerFactory.getLogger(getClass());

	@Autowired
	SessionFactory factory;
	
	
	@SuppressWarnings({ "deprecation"})
	public boolean addTask(Task task) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println(task);
		long check =(long) session.save(task);
		transaction.commit();
		if (check>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public boolean deleteTask(long id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Task>  query = session.createQuery("DELETE FROM Task t WHERE t.taskId = :id");
		query.setParameter("id", id);
		long check = (long) query.executeUpdate();
		transaction.commit();
		if (check>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public boolean updateTask(Task task) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Task> query = session.createQuery("UPDATE Task t SET t.taskName = :taskName"
				+ " WHERE t.taskId = :taskId");
		query.setParameter("taskName",task.getTaskName());
		query.setParameter("taskId",task.getTaskId());
		long check =(long) query.executeUpdate();
		transaction.commit();
		if (check>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Task> getAllTask() {
		Session session = factory.openSession();
		Query<Task> taskQuery = session.createQuery("FROM Task");
		return  taskQuery.list();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public Task getTaskById(long id) {
		Session session = factory.openSession();
		Query<Task>  query = session.createQuery("FROM Task t WHERE t.taskId = :id");
		query.setParameter("id", id);
		try {
			Task task = query.getSingleResult();
			return task;
		} catch (NoResultException e) {
			LOGGER.atDebug();
			LOGGER.debug(null, query, e);
		}
		return null;
	}
}
