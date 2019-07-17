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

import com.cts.task.service.ProjectManagerService;
import com.cts.task.vo.ProjectVO;
import com.cts.task.vo.UserVO;

@RestController
public class ProjectController {

	@Autowired
	ProjectManagerService projectManagerService;
	
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, editor);
	  }
	
	
	@RequestMapping(value="/fetchAllProjects",method = RequestMethod.GET,headers="Accept=application/json")
	  public List<ProjectVO> getAllProjects() {  
	   List<ProjectVO> projectVOs=projectManagerService.getAllProjects();
	   return projectVOs;
	  }
	
	@RequestMapping(value="/fetchAllUsers",method = RequestMethod.GET,headers="Accept=application/json")
	  public List<UserVO> getAllUsers() {  
	   List<UserVO> userVOs=projectManagerService.getAllUsers();
	   return userVOs;
	  }
	
	@RequestMapping(value="/addProject",method = RequestMethod.POST,headers="Accept=application/json")
	  public List<ProjectVO> saveNewProject(@RequestBody ProjectVO projectVO) throws ParseException { 

		projectManagerService.saveProject(projectVO);
	  return projectManagerService.getAllProjects();
	  }    
	
	@RequestMapping(value="/addUser",method = RequestMethod.POST,headers="Accept=application/json")
	  public List<UserVO> saveNewUser(@RequestBody UserVO userVO) throws ParseException { 

		projectManagerService.saveUser(userVO);
	  return projectManagerService.getAllUsers();
	  } 
	
	@RequestMapping(value="/getUser/{employeeId}",method = RequestMethod.GET,headers="Accept=application/json")
	  public UserVO getUserByEmployeeId(@PathVariable int employeeId) {  
	   UserVO userVO=projectManagerService.getUserByEmployeeId(employeeId);
	   return userVO;
	  }
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public void updateUser(@RequestBody UserVO userVO) {
		projectManagerService.updateUser(userVO);
	}
	
	@RequestMapping(value="/getProject/{projectId}",method = RequestMethod.GET,headers="Accept=application/json")
	  public ProjectVO getProjectById(@PathVariable int projectId) {  
		ProjectVO projectVO=projectManagerService.getProjectDetails(projectId);
	   return projectVO;
	  }
	
	@RequestMapping(value = "/updateProject", method = RequestMethod.POST, headers = "Accept=application/json")
	public void updateProject(@RequestBody ProjectVO projectVO) {
		projectManagerService.updateProject(projectVO);
	}
	
	@RequestMapping(value = "/suspendProject/{projectId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void suspendProject(@PathVariable("projectId") int projectId) {
		projectManagerService.deleteProject(projectId);
	}
	
	@RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUser(@PathVariable("userId") int userId) {
		projectManagerService.deleteUser(userId);
	}
}
