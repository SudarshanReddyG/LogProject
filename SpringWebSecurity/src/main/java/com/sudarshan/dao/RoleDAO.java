package com.sudarshan.dao;

import java.util.List;

import com.sudarshan.model.Role;

public interface RoleDAO {
	
	void addRole(Role role);
	
	void updateRole(Role role);
	
	List<Role> getRole(String userName);

}
