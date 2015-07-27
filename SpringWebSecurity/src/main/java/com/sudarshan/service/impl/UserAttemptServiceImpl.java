package com.sudarshan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.dao.UserAttemptDAO;
import com.sudarshan.model.UserAttempt;
import com.sudarshan.service.UserAttemptService;

@Service
public class UserAttemptServiceImpl implements UserAttemptService {
	
	@Autowired
	private UserAttemptDAO userAtmptDao;

	@Override
	public void insertUserAttempt(UserAttempt userAttempt) {
		userAtmptDao.insertUserAttempt(userAttempt);
	}

	@Override
	public void updateUserAttempt(UserAttempt userAttempt) {
		userAtmptDao.updateUserAttempt(userAttempt);
	}

	@Override
	public UserAttempt getuserAttempt(String userName) {
		return userAtmptDao.getuserAttempt(userName);
	}

}
