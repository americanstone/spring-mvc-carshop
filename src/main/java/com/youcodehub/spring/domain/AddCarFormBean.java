package com.youcodehub.spring.domain;

import java.sql.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class AddCarFormBean {
	String platenumber;
	String make;
	String model;
	String vin;
	String cartype;
	Date year;
	CommonsMultipartFile imageData;
	
	public CommonsMultipartFile getImageData() {
		return imageData;
	}
	public void setImageData(CommonsMultipartFile imageData) {
		this.imageData = imageData;
	}
	public String getPlatenumber() {
		return platenumber;
	}
	public void setPlatenumber(String platenumber) {
		this.platenumber = platenumber;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
}
