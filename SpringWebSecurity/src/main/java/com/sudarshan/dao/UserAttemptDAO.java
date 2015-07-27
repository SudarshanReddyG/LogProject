package com.sudarshan.dao;

import com.sudarshan.model.UserAttempt;

public interface UserAttemptDAO {
	
	void insertUserAttempt(UserAttempt userAttempt);
	
	void updateUserAttempt(UserAttempt userAttempt);
	
	UserAttempt getuserAttempt(String userName);
	
}
