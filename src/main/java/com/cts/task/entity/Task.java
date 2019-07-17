package com.cts.task.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
public class Task {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)  
	 @Column(name = "task_id")
	 private int taskId;
	 
	 @Column(name = "task")
	 private String taskName;
	 
	 @Column(name = "parent_id")
	 private int parent_id;
	 
	 @Column(name = "start_date")
	 private Date start_date;
	 
	 @Column(name = "end_date")
	 private Date end_date;
	 
	 @Column(name = "priority")
	 private int priority;
	 
	 @Column(name = "active_flag")
	 private String activeFlag;
	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "project_id")
	 private Project project;
	 
	 @OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL,mappedBy = "task")
	 private User user;

	public int getTask_id() {
		return taskId;
	}

	public void setTask_id(int task_id) {
		this.taskId = task_id;
	}

	

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
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

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
}
