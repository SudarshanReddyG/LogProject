package com.sudarshan.service;

import java.util.List;

import com.sudarshan.model.Role;

public interface RoleService {
	
	void addRole(Role role);
	
	void updateRole(Role role);
	
	List<Role> getRole(String userName);

}
