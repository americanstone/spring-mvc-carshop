package com.youcodehub.spring.repository;

import java.util.List;

import com.youcodehub.spring.domain.Users;

public interface UserDao {
	public List<Users> getUserList();
	public void saveUser(Users user);
	public boolean findUser(String id);
	public boolean validUser(String id,String password);
	public String getRole(String username);
	
}
