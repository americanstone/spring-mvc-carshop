package com.youcodehub.spring.repository;

import java.util.List;

import com.youcodehub.spring.domain.Cars;
import com.youcodehub.spring.domain.Users;

public interface CarDao {
	List<Cars> getCarList();
	List<Cars> getCarList(String username);
	void saveCar(Cars car);
	
	
}
