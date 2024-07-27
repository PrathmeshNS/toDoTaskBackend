package com.todotask.ToDoTask.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todotask.ToDoTask.entity.User;

import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;

@Repository
public class UserRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(user);
		transaction.commit();
		return true;
	}
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public User getUserById(int id) {
		Session session = sessionFactory.openSession();
		Query<User> query = session.createQuery("FROM User u WHERE u.id = :id ");
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public User searchByEmail(String email) {
		Session session = sessionFactory.openSession();
		Query<User> query = session.createQuery("FROM User u WHERE u.email = :email ");
		query.setParameter("email", email);
		try {
			return query.getSingleResult();			
		} catch (NoResultException e ) {
			return null;
		}
	}
	
}
