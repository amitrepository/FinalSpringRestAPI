package com.cts.task.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	 @Column(name = "project_id")
	 private int projectId;
	 
	 @Column(name = "project_name")
	 private String projectName;
	 
	 @Column(name = "start_date")
	 private Date start_date;
	 
	 @Column(name = "end_date")
	 private Date end_date;
	 
	 @Column(name = "priority")
	 private int priority;
	 
	 @Column(name = "active_flag")
	 private String activeFlag;
	 
	 @OneToOne(fetch = FetchType.LAZY,mappedBy="project",cascade = CascadeType.ALL)
	 private User user;
	 
	 
	 @OneToMany(fetch = FetchType.LAZY,mappedBy="project")
	 private Set<Task> tasks= new HashSet<Task>();

	public int getProject_id() {
		return projectId;
	}

	public void setProject_id(int project_id) {
		this.projectId = project_id;
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

	
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
