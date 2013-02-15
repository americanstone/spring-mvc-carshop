package com.youcodehub.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcodehub.spring.domain.Cars;
import com.youcodehub.spring.domain.Users;
import com.youcodehub.spring.repository.CarDao;

@Service
public class SimpleCarManager implements CarManager{
	@Autowired
	private CarDao carDao;
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}
	@Override
	public List<Cars> getCarList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void saveCar(Cars car) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void saveUserCar(String userId, Cars car) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Cars> getUserCarList(String userId) {
		
		return carDao.getCarList(userId);
	}
	

}
