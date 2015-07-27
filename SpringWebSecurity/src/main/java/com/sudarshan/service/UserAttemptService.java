package com.sudarshan.service;

import com.sudarshan.model.UserAttempt;

public interface UserAttemptService {
	
	void insertUserAttempt(UserAttempt userAttempt);
	
	void updateUserAttempt(UserAttempt userAttempt);
	
	UserAttempt getuserAttempt(String userName);
	
}
