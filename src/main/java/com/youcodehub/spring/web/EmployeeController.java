package com.youcodehub.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.youcodehub.spring.service.SimpleEmployeeJobManager;

@Controller
@RequestMapping("/employee")
@SessionAttributes("validUserId")
public class EmployeeController {
	@Autowired
	private SimpleEmployeeJobManager jobManager;
	
	public void setJobManager(SimpleEmployeeJobManager jobManager) {
		this.jobManager = jobManager;
	}

	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String showMain(){
		return "employee/employeeMain";
	}
	
	@RequestMapping(value="/top", method=RequestMethod.GET)
	public String showTop(){
		return "top";
	}
	
	@RequestMapping(value="/employeeMenu", method=RequestMethod.GET)
	public String showMenu(){
		return "employee/employeeMenu";
	}
	
	@RequestMapping(value="/myJobs", method=RequestMethod.GET)
	public String showMyJobs(@ModelAttribute("validUserId") String validUserId, Model model){
		model.addAttribute("myJobs", jobManager.showMyJobs(validUserId));
		return "employee/myJobs";
	}
	

}
