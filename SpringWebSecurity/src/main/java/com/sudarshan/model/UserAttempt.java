package com.sudarshan.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="MYAPP_USER_ATTEMPTS")
public class UserAttempt {
	
	@Id
	@SequenceGenerator(name="ROLE_SEQ", sequenceName="ORA_USR_ATP_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ROLE_SEQ")
	private int id;
	
	private String username;
	
	private int attempts;
	
	@Temporal(TemporalType.DATE)
	private Date lastAttempted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public Date getLastAttempted() {
		return lastAttempted;
	}

	public void setLastAttempted(Date lastAttempted) {
		this.lastAttempted = lastAttempted;
	}
}
