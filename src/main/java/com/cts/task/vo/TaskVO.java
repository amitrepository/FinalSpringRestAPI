package com.cts.task.vo;

import java.util.Date;

public class TaskVO {
	
	private int taskId;
	private String taskName;
	private int parent_task_id;
	private Date start_date;
	private Date end_date;
	private int priority;
	private String activeFlag;
	private int project_id;
	private int userId;
	
	public int getTask_id() {
		return taskId;
	}
	public void setTask_id(int task_id) {
		this.taskId = task_id;
	}
	
	public int getParent_task_id() {
		return parent_task_id;
	}
	public void setParent_task_id(int parent_task_id) {
		this.parent_task_id = parent_task_id;
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
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
