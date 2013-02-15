package com.youcodehub.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Service 
public class UserLoginValidator implements Validator{
	@Autowired
	private UserManager userManager;
	
	public void setUsermanager(UserManager usermanager) {
		this.userManager = usermanager;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return UserLogin.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		UserLogin userlogin = (UserLogin)obj;
		if(userlogin == null){
			errors.rejectValue("userId", "error.not-specified", null, "Value required.");
			errors.rejectValue("password", "error.not-specified", null, "Value required.");
		}else{
			String userId = userlogin.getUserId();
			String password = userlogin.getPassword();
			if(!userManager.isExistUser(userId)){
				errors.rejectValue("userId", "error.not-existed",null,"User not exist.");
			}else{
				if(!userManager.isValidUser(userId, password)){
					errors.rejectValue("password", "error.not-correct",null,"Password is not correct");
				}
			}
		}
	}
}
