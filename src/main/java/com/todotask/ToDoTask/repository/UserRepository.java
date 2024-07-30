package com.todotask.ToDoTask.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todotask.ToDoTask.entity.User;
import com.todotask.ToDoTask.utility.PredefineUserString;

import jakarta.persistence.NoResultException;

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
		Query<User> query = session.createQuery(PredefineUserString.SEARCH_BY_ID);
		query.setParameter(PredefineUserString.VAR_ID, id);
		return query.getSingleResult();
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public User searchByEmail(String email) {
		Session session = sessionFactory.openSession();
		Query<User> query = session.createQuery(PredefineUserString.SEARCH_BY_EMAIL);
		query.setParameter(PredefineUserString.VAR_EMAIL, email);
		try {
			return query.getSingleResult();			
		} catch (NoResultException e ) {
			return null;
		}
	}
	
}
