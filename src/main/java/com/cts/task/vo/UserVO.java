package com.cts.task.vo;

public class UserVO {

	private int user_id;
	private String firstName;
	private String lastName;
	private int employeeId;
	private ProjectVO projectVO;
	private TaskVO taskVO;
	private String activeFlag;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public ProjectVO getProjectVO() {
		return projectVO;
	}
	public void setProjectVO(ProjectVO projectVO) {
		this.projectVO = projectVO;
	}
	public TaskVO getTaskVO() {
		return taskVO;
	}
	public void setTaskVO(TaskVO taskVO) {
		this.taskVO = taskVO;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	
}
