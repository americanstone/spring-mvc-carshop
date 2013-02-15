package com.youcodehub.spring.service;

import java.util.List;

import com.youcodehub.spring.domain.Cars;

public interface CarManager {
	public List<Cars> getCarList();
	public void saveCar(Cars car);
	public void saveUserCar(String userId, Cars car);
	public List<Cars> getUserCarList(String userId);
}
