package com.sudarshan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="MYAPP_USERS_ROLES",uniqueConstraints={@UniqueConstraint(columnNames={"role","username"})})
public class Role {
	
	@Id
	@SequenceGenerator(name="ROLE_SEQ", sequenceName="ORA_ROLE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ROLE_SEQ")
	private int roleId;
	
	//@OneToOne(cascade=CascadeType.ALL)
	@OneToOne
	@JoinColumn(name="username")
	private User user;
	
	private String role;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Role() {
		super();
	}
	
}
