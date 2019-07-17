package com.cts.task.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cts.task.dao.ProjectManagerDAO;
import com.cts.task.dao.TaskManagerDAO;
import com.cts.task.entity.Project;
import com.cts.task.entity.Task;
import com.cts.task.service.TaskManagerService;
import com.cts.task.vo.TaskVO;

@Component
public class TaskManagerServiceImpl implements TaskManagerService {

	private static final Logger logger = Logger.getLogger(TaskManagerServiceImpl.class);
	
	@Autowired
	TaskManagerDAO taskManagerDAO;
	
	@Autowired
	ProjectManagerDAO projectManagerDAO;
	
	@Override
	public
	List<TaskVO> getAllTasks(){
		List<TaskVO> lsTaskVO=new ArrayList<TaskVO>();
		try {
		List<Task> lsTasks=	taskManagerDAO.getAllTasks();

			for (Task task : lsTasks) {
				TaskVO taskVO = new TaskVO();
				BeanUtils.copyProperties(task, taskVO);
				lsTaskVO.add(taskVO);
			}
		} catch (Exception e) {
			logger.error("Error in TaskManagerServiceImpl:getAllTasks() " + e.getMessage());
			throw e;
		}
		return lsTaskVO;
	}

	@Override
	public TaskVO saveTask(TaskVO taskVO) {
		Task task=new Task();
		Project project=null;
		try{
			BeanUtils.copyProperties(taskVO, task);	
			task.setStart_date(new java.sql.Date(taskVO.getStart_date().getTime()));
			task.setEnd_date(new java.sql.Date(taskVO.getEnd_date().getTime())); 
			task.setActiveFlag("Y");
			
			project=projectManagerDAO.getProjectById(taskVO.getProject_id());
			
			 task.setProject(project);
			 task=taskManagerDAO.saveTask(task);
			 
			 boolean updateUser=projectManagerDAO.updateTaskIdForUser(task.getTask_id(), taskVO.getUserId());
			 logger.info("Update flag" + updateUser);
			 
			 BeanUtils.copyProperties(task, taskVO);
		}
		catch (Exception e) {
			logger.error("Error in TaskManagerServiceImpl:getAllTasks() " + e.getMessage());
			throw e;
		}
		return taskVO;
	}

	@Transactional
	@Override
	public TaskVO getTaskbyName(String taskName) {
		TaskVO taskVO=new TaskVO();
		try{
			Task task=taskManagerDAO.fetchTaskbyName(taskName);
			BeanUtils.copyProperties(task, taskVO);
			if(task.getProject()!=null)
			taskVO.setProject_id(task.getProject().getProject_id());
			if(task.getUser()!=null)
			taskVO.setUserId(task.getUser().getUser_id()); 
		}
		catch (Exception e) {
			logger.error("Error in TaskManagerServiceImpl:getTaskbyName() " + e.getMessage());
			throw e;
		}
		return taskVO;
	}

	@Override
	public TaskVO updateTask(TaskVO taskVO) {
		// TODO Auto-generated method stub
		Task task=new Task();
		try{
			BeanUtils.copyProperties(taskVO, task);	
			task.setStart_date(new java.sql.Date(taskVO.getStart_date().getTime()));
			task.setEnd_date(new java.sql.Date(taskVO.getEnd_date().getTime())); 
			
			Project project=projectManagerDAO.fetchProjectByProjectId(taskVO.getProject_id());
			task.setProject(project);
			 task=taskManagerDAO.updateTask(task);
			 
			 boolean updateUser=projectManagerDAO.updateTaskIdForUser(task.getTask_id(), taskVO.getUserId());
			 logger.info("Update flag" + updateUser); 
			 
			BeanUtils.copyProperties(task, taskVO);
		}  
		catch (Exception e) {
			logger.error("Error in TaskManagerServiceImpl:getTaskbyName() " + e.getMessage());
			throw e;
		}
		return taskVO;
	}

	@Override
	public boolean endTask(String taskName) {
		// TODO Auto-generated method stub
		return taskManagerDAO.endTask(taskName);
	}

	@Transactional
	@Override
	public List<TaskVO> getAllTasksByProjectName(String projectName) {
		// TODO Auto-generated method stub
		List<TaskVO> lsTaskVO=new ArrayList<TaskVO>();
		try{
		List<Task>	lsTask=taskManagerDAO.getAllTasksByProjectName(projectName);
		for(Task task:lsTask){
			TaskVO taskVO=new TaskVO();
			BeanUtils.copyProperties(task, taskVO);
			if(task.getProject()!=null)
			taskVO.setProject_id(task.getProject().getProject_id());
			if(task.getUser()!=null)
			taskVO.setUserId(task.getUser().getUser_id());
			lsTaskVO.add(taskVO);
		}
		}
		catch (Exception e) {
			logger.error("Error in TaskManagerServiceImpl:getAllTasksByProjectName() " + e.getMessage());
			throw e;
		}
		return lsTaskVO;
	}
	
}
