package com.sudarshan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.dao.RoleDAO;
import com.sudarshan.model.Role;
import com.sudarshan.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDAO roledao;

	@Override
	public void addRole(Role role) {
		roledao.addRole(role);		
	}

	@Override
	public void updateRole(Role role) {
		roledao.updateRole(role);
	}

	@Override
	public List<Role> getRole(String userName) {
		return roledao.getRole(userName);
	}

}
