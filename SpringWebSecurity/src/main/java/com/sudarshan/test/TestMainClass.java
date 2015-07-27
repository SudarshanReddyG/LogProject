package com.sudarshan.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sudarshan.dao.impl.RoleDAOImpl;
import com.sudarshan.dao.impl.UserAttemptDAOImpl;
import com.sudarshan.dao.impl.UserDAOImpl;
import com.sudarshan.model.Role;
import com.sudarshan.model.User;
import com.sudarshan.model.UserAttempt;

public class TestMainClass {
	
	public static void main(String[] args) {
		
		ApplicationContext appcontext = new ClassPathXmlApplicationContext("com/sudarshan/test/servlet-context.xml");
		
		//Set values in database
		User user = appcontext.getBean("userObj", User.class);
		user.setUsername("sudha");
		user.setPassword("$2a$10$o/Xf7fxMFVyEj3OIYGRJDOADfMHA.ZKPMAiEvT5h0tuGlwFDDC2Om");
		user.setEnabled(true);
		user.setCredentialsNonExpired(true);
		user.setAccountNonLocked(true);
		user.setAccountNonExpired(true);
		
		Role role = appcontext.getBean("roleObj", Role.class);
		role.setUser(user);
		role.setRole("ROLE_ADMIN");
		
		user.setRole(role);
		
		UserDAOImpl userImpl = appcontext.getBean("userDAOObj", UserDAOImpl.class);
		userImpl.addUser(user);
		
		 RoleDAOImpl roleImpl = appcontext.getBean("roleDAOObj", RoleDAOImpl.class);
		 roleImpl.addRole(role);
		
		/*UserAttempt userAttempt = appcontext.getBean("userAtmptObj", UserAttempt.class);
		userAttempt.setAttempts(0);
		userAttempt.setLastAttempted(new Date());
		userAttempt.setUsername("sudarshan");
		
		
		UserAttemptDAOImpl userAttmptDAO = appcontext.getBean("userAtmptDAOObj", UserAttemptDAOImpl.class);
		userAttmptDAO.insertUserAttempt(userAttempt);
		*/
		/*UserDAOImpl userImpl = appcontext.getBean("userDAOObj", UserDAOImpl.class);
		User user = userImpl.getUser("sudarshan");
		System.out.println(user.getUsername() + " "+user.getPassword()+ " " + user.isAccountNonExpired() + " " +user.isAccountNonLocked() + 
							" " + user.isEnabled() + " "+ user.isCredentialsNonExpired() + " " + user.getRole());*/
		
		
		
	}

}
