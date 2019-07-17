package com.cts.task.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class User {

	 @Id
	 @Column(name = "user_id")
	 private int userId;
	 
	 @Column(name = "first_name")
	 private String firstName;
	 
	 @Column(name = "last_name")
	 private String lastName;
	
	 
	 @Column(name = "employee_id")
	 private int employeeId;
	 
	 @OneToOne(cascade= CascadeType.ALL)
	 @JoinColumn(name = "project_id")
	 private Project project;
	 
	 @OneToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "task_id", nullable = false)
	 private Task task;
	 
	 @Column(name = "active_flag")
	 private String activeFlag;


	public int getUser_id() {
		return userId;
	}


	public void setUser_id(int user_id) {
		this.userId = user_id;
	}


	public String getFirst_name() {
		return firstName;
	}


	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}


	public String getLast_name() {
		return lastName;
	}


	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}


	public int getEmployee_id() {
		return employeeId;
	}


	public void setEmployee_id(int employee_id) {
		this.employeeId = employee_id;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	public Task getTask() {
		return task;
	}


	public void setTask(Task task) {
		this.task = task;
	}


	public String getActiveFlag() {
		return activeFlag;
	}


	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	 
	 
}
