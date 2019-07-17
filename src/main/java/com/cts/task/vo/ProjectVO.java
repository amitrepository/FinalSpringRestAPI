package com.cts.task.vo;

import java.sql.Date;
import java.util.ArrayList;

public class ProjectVO {

	 private int project_id;
	 private String projectName;
	 private Date start_date;
	 private Date end_date;
	 private int priority;
	 private String activeFlag;
	 private int userId;
	 ArrayList<TaskVO> lsTasks=new ArrayList<>();
	 private int noOfTasks;
	 private int noOfCompTasks;
	 
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return projectName;
	}
	public void setProject_name(String project_name) {
		this.projectName = project_name;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public ArrayList<TaskVO> getLsTasks() {
		return lsTasks;
	}
	public void setLsTasks(ArrayList<TaskVO> lsTasks) {
		this.lsTasks = lsTasks;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNoOfTasks() {
		return noOfTasks;
	}
	public void setNoOfTasks(int noOfTasks) {
		this.noOfTasks = noOfTasks;
	}
	public int getNoOfCompTasks() {
		return noOfCompTasks;
	}
	public void setNoOfCompTasks(int noOfCompTasks) {
		this.noOfCompTasks = noOfCompTasks;
	}
	
}
