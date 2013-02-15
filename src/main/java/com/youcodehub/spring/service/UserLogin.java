package com.youcodehub.spring.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserLogin {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	private String userId;
	private String password;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
		logger.info("UserLogin " + userId);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
