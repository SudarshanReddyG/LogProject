package com.sudarshan.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sudarshan.dao.RoleDAO;
import com.sudarshan.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
	
	@Autowired
	private SessionFactory sessionfac;

	@Override
	public void addRole(Role role) {
		Session session = sessionfac.getCurrentSession();
		session.beginTransaction();
		session.save(role);
		//session.persist(role);
		session.getTransaction().commit();
	}

	@Override
	public void updateRole(Role role) {
		Session session = sessionfac.getCurrentSession();
		session.beginTransaction();
		session.update(role);
		session.getTransaction().commit();
	}

	@Override
	public List<Role> getRole(String userName) {
		Session session = sessionfac.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Role where user.username=:name");
		query.setString("name", userName);
		List<Role> roles = query.list();
		return roles;
	}

}
