package com.youcodehub.spring.service;

import java.sql.Date;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.youcodehub.spring.domain.AddCarFormBean;
@Service
public class CarAddValidator implements Validator{
	private  static final int MINLENGTH = 8;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AddCarFormBean.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AddCarFormBean carFormBean = (AddCarFormBean)target;
		if(carFormBean == null){
			errors.rejectValue("vin", "error.not-specified", null, "Value required.");
			errors.rejectValue("make", "error.not-specified", null, "Value required.");
			errors.rejectValue("cartype", "error.not-specified", null, "Value required.");
			errors.rejectValue("model", "error.not-specified", null, "Value required.");
			errors.rejectValue("purchasedate", "error.not-specified", null, "Value required.");
			errors.rejectValue("platenumber", "error.not-specified", null, "Value required.");
			errors.rejectValue("file", "error.not-specified", null, "Value required.");
			//errors.rejectValue("imageData", "error.not-specified", null, "Value required.");
		}else{
			
			String vin = carFormBean.getVin();
			String plate = carFormBean.getPlatenumber();
			Date date = carFormBean.getYear();
			//CommonsMultipartFile imageData = carFormBean.getImageData();
			if(vin.length()< MINLENGTH){
				errors.rejectValue("vin","error.invalid",null,"Value pattern min 8 characters!");
			}else if(plate.length() < MINLENGTH){
				errors.rejectValue("platenumber", "errors.invalid", null, "Value pattern min 8 characters!");
			}
			/*else if(imageData.isEmpty()){
				errors.rejectValue("imageData", "errors.invalid", null, "image can not be empty!");
			}*/
		}
		
	}

}
