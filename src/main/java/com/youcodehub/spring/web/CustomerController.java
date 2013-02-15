package com.youcodehub.spring.web;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.youcodehub.spring.domain.AddCarFormBean;
import com.youcodehub.spring.domain.Cars;
import com.youcodehub.spring.service.CarAddValidator;
import com.youcodehub.spring.service.CarManager;
import com.youcodehub.spring.service.UserManager;

@Controller
@RequestMapping("/user")
@SessionAttributes("validUserId")
public class CustomerController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private UserManager userManager;
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	@Autowired 
	private CarManager carManager;
	
	public void setCarManager(CarManager carManager) {
		this.carManager = carManager;
	}
	@Autowired
	private CarAddValidator carAddValidator;
	
	public void setCarAddValidator(CarAddValidator carAddValidator) {
		this.carAddValidator = carAddValidator;
	}

	/*create the addCarFormBean*/
	@ModelAttribute
	public AddCarFormBean createCarFormBean(){
		return new AddCarFormBean();
	}
	/*@RequestMapping(value="main",method=RequestMethod.GET)
	public String show(){
			return "customerMain";	
	}*/
	
	/*either you get userId from url request @PathVariable()
	 * or can get the userId from session just replace the @pathVariable
	 * to @ModelAttribte("vaildUserId")
	 * */
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String showMain(@ModelAttribute("validUserId") String userId){
		String role = userManager.getRole(userId);
		if(role.equalsIgnoreCase("customer")){
			logger.info("Customer " + userId + "logined.");
			return "customerMain";
		}else if(role.equalsIgnoreCase("admin")){
			logger.info("Admin " + userId + "logined.");
			return "adminMain";
		}else{
			logger.info("Not valid user " + userId + ".");
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value="/customerMenu",method=RequestMethod.GET)
	public String showMenu(){
		//@PathVariable String customerId
		return "customerMenu";
	}
	
	/*either you put Model as a param and adding attribute into it
	 * or return a ModelAndView
	 * */
	@RequestMapping(value="/top",method=RequestMethod.GET)
	public String showTop(@ModelAttribute("validUserId") String userId, Model model){
		model.addAttribute("validUserId", userId );
		return "top";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session =request.getSession();
		
		session.invalidate();
		return "redirect:/login"; /* here is redirect !!!! not just login */
	}
	
	@RequestMapping(value="/showMyCar",method=RequestMethod.GET)
	public String showMyCar(@ModelAttribute("validUserId") String userId, Model model){
		List<Cars> cars = carManager.getUserCarList(userId);
		model.addAttribute("myCars", cars);
		logger.info("Show " + userId +"'s cars.");
		return "showCar";
	}
	
	/*the @ModelAttribute here is just for denote purpose since we already created a AddCarFormBean 
	 * in previous method 
	 *  */
	@RequestMapping(value="/car/addCar", method=RequestMethod.GET)
	public String addCar(@ModelAttribute("addCarFormBean") AddCarFormBean addCarFormBean, Model model){
		return "addCarForm";
	}
	
	
	/* 
	/* if automatically validate a command object after it has been bound 
	 * use @Valid Cars car
	 * 
	 * By default all model attributes are considered to be exposed as URI 
	 * template variables in the redirect URL. Of the remaining attributes 
	 * those that are primitive types or collections/arrays of primitive 
	 * types are automatically appended as query parameters.
	 * 
	 * But we want get previous model info even after redirection 
	 * in this case, have to bring RedirectAttributes
	 * */
	
	/*
	@RequestMapping(value="/car/addCar",method=RequestMethod.POST)
	@Transactional
	public String add(@ModelAttribute("assCarFormBean") AddCarFormBean addCarFormBean, BindingResult result
			,Model model, RedirectAttributes redirectAttrs){
		carAddValidator.validate(addCarFormBean, result);
		if(result.hasErrors()){
			return "addCarForm";
		}
		String message = "Form submitted successfully.  Bound " + addCarFormBean;
		CommonsMultipartFile rawfile = addCarFormBean.getFileData();
		byte[] rawbyte = rawfile.getBytes();
		
		//carManager.saveCar(car);
		redirectAttrs.addFlashAttribute("message", message);
		return "redirect:/user/car/addCar";
	}*/
	
	@RequestMapping(value="/car/addCar",method=RequestMethod.POST)
	@Transactional  
	public String add(@ModelAttribute("assCarFormBean") AddCarFormBean addCarFormBean, BindingResult result
			,Model model, RedirectAttributes redirectAttrs) throws IOException{
		
		carAddValidator.validate(addCarFormBean, result);
		if(result.hasErrors()){
			//return "addCarForm"; /*car/addCarForm indicate go to car directory find addCarForm.jsp */
			return null;
		}
		String message = "Form submitted successfully.  Bound " + addCarFormBean;
		/*CommonsMultipartFile rawfile = addCarFormBean.getFileData();
		byte[] rawbyte = rawfile.getBytes();*/
		//byte[] rawbyte = imageData.getBytes();
		
		//carManager.saveCar(car);
		redirectAttrs.addFlashAttribute("message", message);
		return "redirect:/user/car/addCar";
	}
	
	/*@RequestMapping(method=RequestMethod.POST)
	public void processUpload(@RequestPart MultipartFile file, Model model) throws IOException {
		model.addAttribute("message", "File '" + file.getOriginalFilename() + "' uploaded successfully");
	}*/
	
	/*@RequestMapping("/")
	public void printRequestBody(@RequestBody String body,Writer writer){
		logger.info(body);
	}
*/
}
