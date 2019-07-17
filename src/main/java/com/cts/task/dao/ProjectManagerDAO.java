package com.cts.task.dao;

import java.util.List;

import com.cts.task.entity.Project;
import com.cts.task.entity.User;

public interface ProjectManagerDAO {

	
	List<Project> getAllProjects();
	
	List<User> getAllUsers();
	
	Project saveProject(Project project);
	
	User saveUser(User user);
	
	User fetchUserByEmployeeId(int employeeId);
	
	User updateUser(User user);
	
	Project fetchProjectByProjectId(int projectId);
	
	Project updateProject(Project project);
	
	boolean updateProjectIdForUser(int projectId,int userId);
	
	boolean updateTaskIdForUser(int taskId,int userId);
	
	Project getProjectById(int projectId);
	
	boolean suspendProject(int projectId);
	
	boolean deleteUser(int userId);
}
