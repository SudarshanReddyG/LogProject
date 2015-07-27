package com.sudarshan.dao;

import com.sudarshan.model.User;

public interface UserDAO {
	
	void addUser(User user);
	
	User getUser(String userName);
	
	void deleteUser(String userName);
	
	void updateUser(User user);

}
