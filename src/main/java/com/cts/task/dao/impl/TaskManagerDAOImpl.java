package com.cts.task.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.task.dao.TaskManagerDAO;
import com.cts.task.entity.Task;
import com.cts.task.repositories.TaskRepository;

@Component
public class TaskManagerDAOImpl implements TaskManagerDAO {

	@Autowired
	TaskRepository taskRepository;
	
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}

	@Override
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub
		task=taskRepository.save(task);
		taskRepository.flush();
		return task;
	}

	@Override
	public Task fetchTaskbyName(String task_name) {
		// TODO Auto-generated method stub
		return taskRepository.findByTaskName(task_name);
	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
	Task taskFrmDB=taskRepository.findByTaskName(task.getTaskName());
	taskFrmDB.setParent_id(task.getParent_id());
	taskFrmDB.setPriority(task.getPriority());
	taskFrmDB.setStart_date(task.getStart_date());
	taskFrmDB.setEnd_date(task.getEnd_date());
	taskFrmDB.setProject(task.getProject());
	taskRepository.save(taskFrmDB);
	taskRepository.flush();
	return taskFrmDB;
	}

	@Override
	public boolean endTask(String taskName) {
		int update =taskRepository.updateTask("Y", taskName);
		if(update>0)
		  return true;
		else
	      return false;
	}

	@Override
	public List<Task> getAllTasksByProjectName(String projectName) {
		// TODO Auto-generated method stub
		return taskRepository.findByProject_ProjectName(projectName);
	}
	
}

