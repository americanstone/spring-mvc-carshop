package com.youcodehub.spring.service;

import java.util.List;

import com.youcodehub.spring.domain.RepairJob;
import com.youcodehub.spring.domain.Request;

public interface EmployeeJobManager {
	
	public List<Request> showMyResponsibleRequests(String myName);
	
	public RepairJob getRepairJobById(int id);
	
	public List<EmployeeJob> showMyJobs(String myName);

}
