package com.youcodehub.spring.service;

public class EmployeeJob {
	private int jobId;
	private String customer;
	private String plateNumber;
	private String problem;
	private String category;
	private String status;
	private float estimatedCost;
	private int estimatedDays;
	private String personInCharge;
	private String assignTo;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getEstimatedCost() {
		return estimatedCost;
	}
	public void setEstimatedCost(float estimatedCost) {
		this.estimatedCost = estimatedCost;
	}
	public int getEstimatedDays() {
		return estimatedDays;
	}
	public void setEstimatedDays(int estimatedDays) {
		this.estimatedDays = estimatedDays;
	}
	public String getPersonInCharge() {
		return personInCharge;
	}
	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	
	
}
