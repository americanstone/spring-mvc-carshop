package com.youcodehub.spring.domain;

import java.sql.Date;

public class RepairJob {

	private int rid;
	private String status;
	private String name;
	private String description;
	private int cid;
	private Date starttime;
	private Date completetime;
	private float estimatedcost;
	private int estimateddays;
	private String comments;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getCompletetime() {
		return completetime;
	}
	public void setCompletetime(Date completetime) {
		this.completetime = completetime;
	}
	public float getEstimatedcost() {
		return estimatedcost;
	}
	public void setEstimatedcost(float estimatedcost) {
		this.estimatedcost = estimatedcost;
	}
	public int getEstimateddays() {
		return estimateddays;
	}
	public void setEstimateddays(int estimateddays) {
		this.estimateddays = estimateddays;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
