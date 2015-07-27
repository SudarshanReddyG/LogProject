package com.sudarshan.service;

import com.sudarshan.model.User;

public interface UserService {
	
	void addUser(User user);
	
	User getUser(String userName);
	
	void deleteUser(String userName);
	
	void updateUser(User user);

}
