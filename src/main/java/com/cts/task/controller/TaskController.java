package com.cts.task.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.task.service.TaskManagerService;
import com.cts.task.vo.TaskVO;

@RestController
public class TaskController {

	@Autowired
	TaskManagerService taskManagerService;
	
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, editor);
	  }
	
	@RequestMapping(value="/tasks",method = RequestMethod.GET,headers="Accept=application/json")
	  public List<TaskVO> getAllTasks() {  
	   List<TaskVO> taskVOs=taskManagerService.getAllTasks();
	   return taskVOs;
	  }
	
	@RequestMapping(value="/tasks/insert/{taskName}/{parentTask}/{startDate}/{endDate}/{priority}",method = RequestMethod.POST,headers="Accept=application/json")
	  public List<TaskVO> addTask(@PathVariable String taskName,@PathVariable int parentTask,@PathVariable Date startDate,@PathVariable Date endDate,@PathVariable int priority) throws ParseException { 
	  TaskVO taskVO = new TaskVO();
	  taskVO.setTaskName(taskName);
	  taskVO.setParent_task_id(parentTask);
	  taskVO.setStart_date(startDate);
	  taskVO.setEnd_date(endDate);
	  taskVO.setPriority(priority);
	  taskManagerService.saveTask(taskVO);
	  return taskManagerService.getAllTasks();
	  }    
	
	@RequestMapping(value="/getTask/{taskName}",method = RequestMethod.GET,headers="Accept=application/json")
	  public TaskVO getTaskbyName(@PathVariable String taskName) {  
	   TaskVO taskVO=taskManagerService.getTaskbyName(taskName);
	   return taskVO;
	  }
	
	@RequestMapping(value="/tasks/addTask",method = RequestMethod.POST,headers="Accept=application/json")
	  public List<TaskVO> saveNewTask(@RequestBody TaskVO taskVO) throws ParseException { 

	  taskManagerService.saveTask(taskVO);
	  return taskManagerService.getAllTasks();
	  }    
	
	@RequestMapping(value = "/updateTask", method = RequestMethod.POST, headers = "Accept=application/json")
	public void updateTask(@RequestBody TaskVO taskVO) {
		 taskManagerService.updateTask(taskVO);
	}
 
	@RequestMapping(value = "/deleteTask/{taskName}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@PathVariable("taskName") String taskName) {
		taskManagerService.endTask(taskName);
	} 
	 
	
	@RequestMapping(value="/getTasksByProject/{projectName}",method = RequestMethod.GET,headers="Accept=application/json")
	  public List<TaskVO> getAllTasksByProjectName(@PathVariable String projectName) {  
	   List<TaskVO> taskVOs=taskManagerService.getAllTasksByProjectName(projectName);
	   return taskVOs;
	  }
}
