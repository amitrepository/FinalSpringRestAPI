package com.cts.task.dao;

import java.util.List;

import com.cts.task.entity.Task;

public interface TaskManagerDAO {

	List<Task> getAllTasks();
	
	Task saveTask(Task task);
	
	Task fetchTaskbyName(String task_name);
	
	Task updateTask(Task task);
	
	boolean endTask(String taskName);
	
	List<Task> getAllTasksByProjectName(String projectName);
}
