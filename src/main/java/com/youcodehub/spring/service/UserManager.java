package com.youcodehub.spring.service;

import java.util.List;

import com.youcodehub.spring.domain.Users;

public interface UserManager {

	public List<Users> getUserList();
	public boolean isExistUser(String userId);
	public boolean isValidUser(String userId, String password);
	public void registerUser(Users user);
	public String getRole(String userId);
	public Users getUserbyUsername(String username);
	
}
