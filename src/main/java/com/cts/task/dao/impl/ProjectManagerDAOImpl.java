package com.cts.task.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.task.dao.ProjectManagerDAO;
import com.cts.task.entity.Project;
import com.cts.task.entity.User;
import com.cts.task.repositories.ProjectRepository;
import com.cts.task.repositories.TaskRepository;
import com.cts.task.repositories.UserRepository;

@Component
public class ProjectManagerDAOImpl implements ProjectManagerDAO {

	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Project saveProject(Project project) {
		// TODO Auto-generated method stub
		project= projectRepository.save(project);
		projectRepository.flush();
		return  project;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		user=userRepository.save(user);
		userRepository.flush();
		return user;
	}

	@Override
	public User fetchUserByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return userRepository.findByemployeeId(employeeId);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
	User userFrmDB=userRepository.findByUserId(user.getUser_id());
	userFrmDB.setFirst_name(user.getFirst_name());
	userFrmDB.setLast_name(user.getLast_name());
	userFrmDB.setEmployee_id(user.getEmployee_id());
	user=userRepository.save(user);
	userRepository.flush();
	return user;
	}

	@Override
	public Project fetchProjectByProjectId(int projectId) {
		// TODO Auto-generated method stub
		return projectRepository.findByProjectId(projectId);
	}

	@Override
	public Project updateProject(Project project) {
		// TODO Auto-generated method stub
		Project proFromDB=projectRepository.findByProjectId(project.getProject_id());
		proFromDB.setProject_name(project.getProject_name());
		proFromDB.setPriority(project.getPriority());
		proFromDB.setActiveFlag(project.getActiveFlag());
		proFromDB.setStart_date(project.getStart_date());
		proFromDB.setEnd_date(project.getEnd_date());
		project=projectRepository.save(proFromDB);
		projectRepository.flush();
		return project;
	}

	@Override
	public boolean updateProjectIdForUser(int projectId, int userId) {
		// TODO Auto-generated method stub
		int update =userRepository.updateProjectId(projectId, userId);
		if(update>0)
		  return true;
		else
	      return false;
	}

	@Override
	public boolean updateTaskIdForUser(int taskId, int userId) {
		// TODO Auto-generated method stub
		int update =userRepository.updateTaskId(taskId, userId);
		if(update>0)
		  return true;
		else
		return false;
	}

	@Override
	public Project getProjectById(int projectId) {
		// TODO Auto-generated method stub
		return projectRepository.findByProjectId(projectId);
	}

	@Override
	public boolean suspendProject(int projectId) {
		// TODO Auto-generated method stub
		int update=projectRepository.deleteProject(projectId);
		if(update>0)
			return true;
		else
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		int update=userRepository.updateUserStatus("N", userId);
		if(update>0)
			return true;
		else
		return false;
	}
	
	
	
}
