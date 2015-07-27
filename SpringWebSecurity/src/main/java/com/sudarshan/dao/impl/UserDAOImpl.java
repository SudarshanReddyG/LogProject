package com.sudarshan.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sudarshan.dao.UserDAO;
import com.sudarshan.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFac;

	@Override
	public void addUser(User user) {
		Session session = sessionFac.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

	@Override
	public User getUser(String userName) {
		Session session = sessionFac.getCurrentSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, userName);
		session.getTransaction().commit();
		return user;
	}

	@Override
	public void deleteUser(String userName) {
		Session session = sessionFac.getCurrentSession();
		session.beginTransaction();
		User user = new User();
		user.setUsername(userName);
		session.delete(user);
		session.getTransaction().commit();
	}

	@Override
	public void updateUser(User user) {
		Session session = sessionFac.getCurrentSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}

}
