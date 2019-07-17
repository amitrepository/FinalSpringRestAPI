package com.cts.task.service;

import java.util.List;

import com.cts.task.vo.ProjectVO;
import com.cts.task.vo.UserVO;

public interface ProjectManagerService {

	List<ProjectVO> getAllProjects();
	List<UserVO> getAllUsers();
	ProjectVO saveProject(ProjectVO projectVO);
	UserVO saveUser(UserVO userVO);
	UserVO getUserByEmployeeId(int employeeId);
	UserVO updateUser(UserVO userVO);
	ProjectVO getProjectDetails(int projectId);
	ProjectVO updateProject(ProjectVO projectVO);
	boolean deleteProject(int projectId);
	boolean deleteUser(int userId);
	
}
