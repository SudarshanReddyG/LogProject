package com.sudarshan.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sudarshan.dao.UserAttemptDAO;
import com.sudarshan.model.UserAttempt;

@Repository
public class UserAttemptDAOImpl implements UserAttemptDAO {
	
	
	@Autowired
	private SessionFactory sessionFac;
	
	@Override
	public void insertUserAttempt(UserAttempt userAttempt) {
		Session session = sessionFac.getCurrentSession();
		session.beginTransaction();
		session.save(userAttempt);
		session.getTransaction().commit();
	}

	@Override
	public void updateUserAttempt(UserAttempt userAttempt) {
		Session session = sessionFac.getCurrentSession();
		session.beginTransaction();
		session.update(userAttempt);
		session.getTransaction().commit();
	}

	@Override
	public UserAttempt getuserAttempt(String userName) {
		Session session = sessionFac.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from UserAttempt ua where ua.username=:name");
		query.setString("name", userName);
		
		UserAttempt userAttmpt = (UserAttempt) query.uniqueResult();
		session.getTransaction().commit();
		return userAttmpt;
	}

}
