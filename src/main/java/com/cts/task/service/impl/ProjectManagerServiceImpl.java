package com.cts.task.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cts.task.dao.ProjectManagerDAO;
import com.cts.task.entity.Project;
import com.cts.task.entity.Task;
import com.cts.task.entity.User;
import com.cts.task.service.ProjectManagerService;
import com.cts.task.vo.ProjectVO;
import com.cts.task.vo.UserVO;

@Component
public class ProjectManagerServiceImpl implements ProjectManagerService {

	private static final Logger logger = Logger.getLogger(ProjectManagerServiceImpl.class);
	
	@Autowired
	ProjectManagerDAO projectDAO;

	@Override
	@Transactional
	public List<ProjectVO> getAllProjects() {
		// TODO Auto-generated method stub
		List<ProjectVO> projectVOS=new ArrayList<ProjectVO>();

		int activeCount=0;
		int compCount=0;
		try{
			
		List<Project> projects=projectDAO.getAllProjects();
		for(Project pro:projects){
			ProjectVO projectVO=new ProjectVO();
			activeCount=0;
			compCount=0; 
			BeanUtils.copyProperties(pro, projectVO);
			if(pro.getUser()!=null){
				projectVO.setUserId(pro.getUser().getUser_id());
			}
			if(!pro.getTasks().isEmpty()){
				for(Task task:pro.getTasks()){
					if(task!=null && task.getActiveFlag()!=null && task.getActiveFlag().equals("Y")){
						activeCount++;
					}
					else if (task!=null && task.getActiveFlag()!=null && task.getActiveFlag().equals("N")){
						compCount++;
					}
				}
			}
			projectVO.setNoOfTasks(activeCount); 
			projectVO.setNoOfCompTasks(compCount);
			
			projectVOS.add(projectVO);
		}
		}
		catch(Exception e){
			logger.error("Error in ProjectManagerServiceImpl:getAllProjects() " + e.getMessage());
			throw e;
		}
		return projectVOS;
	}

	@Override
	public List<UserVO> getAllUsers() {
		// TODO Auto-generated method stub
		List<UserVO> lsUserVO=new ArrayList<>();
		try{
			List<User> users=projectDAO.getAllUsers();
			for(User user:users){
				UserVO userVO=new UserVO();
				BeanUtils.copyProperties(user, userVO);
				lsUserVO.add(userVO);
			}
		}
		catch(Exception e){
			logger.error("Error in ProjectManagerServiceImpl:getAllUsers() " + e.getMessage());
			throw e;
		}
		return lsUserVO;
	}

	@Override
	public ProjectVO saveProject(ProjectVO projectVO) {
		// TODO Auto-generated method stub
		
		Project project=new Project();
		try{
			BeanUtils.copyProperties(projectVO, project);	
			project.setStart_date(new java.sql.Date(projectVO.getStart_date().getTime()));
			project.setEnd_date(new java.sql.Date(projectVO.getEnd_date().getTime())); 
			project=projectDAO.saveProject(project);
			
			boolean updateUser=projectDAO.updateProjectIdForUser(project.getProject_id(), projectVO.getUserId());
			logger.info("Update flag" + updateUser);
			 BeanUtils.copyProperties(project, projectVO);
		}
		catch (Exception e) {
			logger.error("Error in ProjectManagerServiceImpl:saveProject() " + e.getMessage());
			throw e;
		}
		return projectVO;
	}

	@Override
	public UserVO saveUser(UserVO userVO) {
		// TODO Auto-generated method stub
		User user=new User();
		try{
			BeanUtils.copyProperties(userVO, user);	
			user=projectDAO.saveUser(user);
			BeanUtils.copyProperties(user, userVO);
		}
		catch (Exception e) {
			logger.error("Error in ProjectManagerServiceImpl:saveUser() " + e.getMessage());
			throw e;
		}
		return userVO;
	}

	@Override
	public UserVO getUserByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		UserVO userVO=new UserVO();
		try{
			User user=projectDAO.fetchUserByEmployeeId(employeeId);
			BeanUtils.copyProperties(user, userVO);
		}
		catch (Exception e) {
			logger.error("Error in ProjectManagerServiceImpl:getUserByEmployeeId() " + e.getMessage());
			throw e;
		}
		return userVO;
	}

	@Override
	public UserVO updateUser(UserVO userVO) {
		// TODO Auto-generated method stub
		User user=new User();
		try{
			BeanUtils.copyProperties(userVO, user);
			user=projectDAO.updateUser(user);
			BeanUtils.copyProperties(user, userVO);
		}
		catch (Exception e) {
			logger.error("Error in ProjectManagerServiceImpl:updateUser() " + e.getMessage());
			throw e;
		}
		return userVO;
	}

	@Override
	public ProjectVO getProjectDetails(int projectId) {
		// TODO Auto-generated method stub
		ProjectVO projectVO=new ProjectVO();
		try{
			Project project=projectDAO.fetchProjectByProjectId(projectId);
			BeanUtils.copyProperties(project, projectVO);
		}
		catch (Exception e) {
			logger.error("Error in ProjectManagerServiceImpl:getProjectDetails() " + e.getMessage());
			throw e;
		}
		return projectVO;
	}

	@Override
	public ProjectVO updateProject(ProjectVO projectVO) {
		// TODO Auto-generated method stub
		Project project=new Project();
		try{
			BeanUtils.copyProperties(projectVO, project);
			project=projectDAO.updateProject(project);
			boolean updateUser=projectDAO.updateProjectIdForUser(project.getProject_id(), projectVO.getUserId());
			logger.info("Update flag" + updateUser);
			
			BeanUtils.copyProperties(project, projectVO);
		}
		catch (Exception e) {
			logger.error("Error in ProjectManagerServiceImpl:updateProject() " + e.getMessage());
			throw e;
		}
		return projectVO;
	}

	@Override
	public boolean deleteProject(int projectId) {
		// TODO Auto-generated method stub
		
		return projectDAO.suspendProject(projectId);
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		return projectDAO.deleteUser(userId);
	}
	
	
	
}
