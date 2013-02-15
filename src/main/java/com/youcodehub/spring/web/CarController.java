package com.youcodehub.spring.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.youcodehub.spring.domain.Cars;
import com.youcodehub.spring.service.CarManager;
import com.youcodehub.spring.service.CarAddValidator;


@RequestMapping("/car")
@Transactional
@SessionAttributes("validUser")
public class CarController {
	@Autowired
	private CarManager carManager;
	@Autowired
	private CarAddValidator carAddValidator;

	/*create add car form*/
	@ModelAttribute
	public Cars createCarFormBean(){
		return new Cars();
	}
	
	/* show add car form */
	@RequestMapping(value="/addCar",method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public String showAddCarForm(){
		return "addCarForm";
	}
	
	/* 
	/* if automatically validate a command object after it has been bound 
	 * use @Valid Cars car
	 * */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@Transactional
	public String add(@ModelAttribute("cars") Cars car, BindingResult result
			,Model model){
		carAddValidator.validate(car, result);
		if(result.hasErrors()){
			return "/car/add";
		}
		carManager.saveCar(car);
		return "redirect:/car/showCar";
	}

}
