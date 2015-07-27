package com.sudarshan.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sudarshan.dao.UserDAO;

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAO userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		com.sudarshan.model.User myAppUsr = userDao.getUser(username);
		
		if(myAppUsr == null)
			throw new UsernameNotFoundException("The user "+username+" is not a registered user");
		
		com.sudarshan.model.Role myAppRole = myAppUsr.getRole();
		
		
		
		UserDetails user = new User(myAppUsr.getUsername(), myAppUsr.getPassword(), myAppUsr.isEnabled(),
				myAppUsr.isAccountNonExpired(), myAppUsr.isCredentialsNonExpired(), myAppUsr.isAccountNonLocked(),
				getAuthorities(myAppRole));
		
		return user;
	}
	
	private ArrayList<GrantedAuthority> getAuthorities(com.sudarshan.model.Role role) {
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority grantedtedAuth = new SimpleGrantedAuthority(role.getRole());
		authorities.add(grantedtedAuth);
		return authorities;
	}

}
