package com.youcodehub.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.youcodehub.spring.domain.Category;
import com.youcodehub.spring.domain.RepairJob;
import com.youcodehub.spring.domain.Request;
import com.youcodehub.spring.domain.Users;
import com.youcodehub.spring.repository.CategoryDao;
import com.youcodehub.spring.repository.RepairJobDao;
import com.youcodehub.spring.repository.RequestDao;
import com.youcodehub.spring.repository.UserDao;

public class SimpleEmployeeJobManager implements EmployeeJobManager{
	@Autowired
	private RequestDao requestDao;
	
	public void setRequestDao(RequestDao requestDao) {
		this.requestDao = requestDao;
	}

	@Autowired
	private RepairJobDao repairJobDao;
	
	public void setRepairJobDao(RepairJobDao repairJobDao) {
		this.repairJobDao = repairJobDao;
	}


	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	private CategoryDao categoryDao;	

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}


	@Override
	public List<Request> showMyResponsibleRequests(String myName) {
		return requestDao.getRequestsByOwner(myName);
	}


	@Override
	public RepairJob getRepairJobById(int id) {
		return repairJobDao.getRepairJobById(id);
	}


	@Override
	public List<EmployeeJob> showMyJobs(String myName) {
		List<EmployeeJob> myJobs = new ArrayList<EmployeeJob>();
		List<Request> requests = requestDao.getRequestsByOwner(myName);
		for(Request request : requests){
			//get repair job by rid;
			RepairJob repairJob = repairJobDao.getRepairJobById(request.getRid());
			//get customer fname lname by username
			Users customer = userDao.getUserbyUsername(request.getUsername());
			//get person in charge fname lname by username
			Users owner = userDao.getUserbyUsername(request.getPersonincharge());
			//get problem category by Id
			Category category = categoryDao.getCategoryById(repairJob.getCid());
			//fill data
			EmployeeJob myJob = new EmployeeJob();
			myJob.setJobId(request.getRid());
			myJob.setCustomer(customer.getFname() + " " + customer.getLname());
			myJob.setPlateNumber(request.getPlatenumber());
			myJob.setProblem(repairJob.getName());
			myJob.setCategory(category.getName());
			myJob.setStatus(repairJob.getStatus());
			myJob.setEstimatedCost(repairJob.getEstimatedcost());
			myJob.setEstimatedDays(repairJob.getEstimateddays());
			myJob.setPersonInCharge(owner.getFname() + " " + owner.getLname());
			myJobs.add(myJob);
		}
		
		return myJobs;
	}

}
