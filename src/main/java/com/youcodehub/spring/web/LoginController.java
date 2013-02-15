package com.youcodehub.spring.web;

import java.util.Date;


import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.youcodehub.spring.service.CarManager;
import com.youcodehub.spring.service.UserLoginValidator;
import com.youcodehub.spring.service.UserManager;
import com.youcodehub.spring.service.UserLogin;

@Controller
@RequestMapping("/login")
@SessionAttributes("validUserId")

public class LoginController{

	protected final Log logger = LogFactory.getLog(getClass());
	
/*	@Autowired
	private UserManager userManager;
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}*/
	@Autowired
	private UserLoginValidator validator;
	
	public void setValidator(UserLoginValidator validator) {
		this.validator = validator;
	}
	@Autowired
	private CarManager carManager;

	public void setCarManager(CarManager carManager) {
		this.carManager = carManager;
	}

	@ModelAttribute
	public UserLogin createuserLoginFormBean(){
		return new UserLogin();
	}
	
	/*handle login page*/
	/*either create command object first or denote as method param
	 * so if ignore following UserLogin param, login still workds
	 * */
	@RequestMapping(method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public String loginForm(UserLogin userlogin, Model model){
		return "login";
	}
	
	/*handle login submit*/
   @RequestMapping(method=RequestMethod.POST)
   public String onSubmit(@ModelAttribute("userLogin")  UserLogin userlogin,
		   BindingResult result, ModelMap model)
            throws ServletException {
	   validator.validate(userlogin, result);
	   	if(result.hasErrors()){
	   		return "login";
	   	}
	   	String userId = userlogin.getUserId();
        logger.info("User logined  " + userId + ".");
       
	   	/*success login user will be added to session*/
	   	model.addAttribute("validUserId", userId); /*this value will present in url param why?*/
	   	/*model.addAttribute("mycar",carManager.getUserCarList(userId));
	    logger.info("Inside of Model " + model.toString());
	   	String role = userManager.getRole(userId);
	   	if(role.equals("customer")){*/
	   		/*in this business(logic) design, the login-controller redirect page according to user's role */
	   		/*other design may like this, controller return only one view but the url will along with the 
	   		 * login user role information, that url will map to another controller, the controller will 
	   		 * use @PathVarable extract the role info
	   		 * */
	   		
	   		/*
	   		 * in this design, I want to pass the model which was generated by login controller pass to 
	   		 * another controller(customerController) which will take care of the model object and extract 
	   		 * the value in another view.
	   		 * 
	   		 * but there is maybe have another shot, in stead of login controller generate the model which related 
	   		 * login user, in this case, the model is the cars login user have. login controller just set session 
	   		 * the coustomerContoller grab the session infor and create model in order that jsp can display the 
	   		 * model values
		   	 */
	   /*		
	   		return "redirect:customer/customerMain";the url structure don't indicate the folder structure customer may not exist
	   	}else{
	   		return "redirect:adminMain";
	   	}*/
	   	
	   	return "redirect:user/main";
	   //	return "redirect:user/main"+ userId;
       
    }
}
