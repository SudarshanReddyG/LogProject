package com.sudarshan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.dao.UserDAO;
import com.sudarshan.model.User;
import com.sudarshan.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userdao;
	
	@Override
	public void addUser(User user) {
		userdao.addUser(user);
	}

	@Override
	public User getUser(String userName) {
		return userdao.getUser(userName);
	}

	@Override
	public void deleteUser(String userName) {
		userdao.deleteUser(userName);
	}

	@Override
	public void updateUser(User user) {
		userdao.updateUser(user);		
	}

}
