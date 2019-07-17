package com.cts.task.service;

import java.util.List;

import com.cts.task.vo.TaskVO;

public interface TaskManagerService {

	List<TaskVO> getAllTasks();
	
	TaskVO saveTask(TaskVO taskVO);
	
	TaskVO getTaskbyName(String taskName);
	
	TaskVO updateTask(TaskVO taskVO);
	
	boolean endTask(String taskName);
	
	List<TaskVO> getAllTasksByProjectName(String projectName);
}
