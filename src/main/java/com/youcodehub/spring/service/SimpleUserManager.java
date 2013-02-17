package com.youcodehub.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcodehub.spring.domain.Users;
import com.youcodehub.spring.repository.UserDao;
@Service
public class SimpleUserManager implements UserManager{
	@Autowired
	private UserDao userDao;
	
	public UserDao getUserdao() {
		return userDao;
	}

	public void setUserdao(UserDao userdao) {
		this.userDao = userdao;
	}
	
	@Override
	public List<Users> getUserList() {
		
		return userDao.getUserList();
	}

	@Override
	public boolean isExistUser(String userId) {
		
		return userDao.findUser(userId);
	}

	@Override
	public boolean isValidUser(String userId, String password) {
		return userDao.validUser(userId, password);
	}

	@Override
	public void registerUser(Users user) {
		userDao.saveUser(user);
	}

	@Override
	public String getRole(String userId) {
		return userDao.getRole(userId);
	}

	@Override
	public Users getUserbyUsername(String username) {
		return userDao.getUserbyUsername(username);
	}
	

}
