package com.cts.task.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.task.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Override
	List<User> findAll();
	
	public <S extends User> S save(S arg0);
	
	User findByFirstNameOrLastName(String firstName,String lastName);
	
	User findByProject_ProjectId(int project_id);
	
	User findByTask_TaskId(int task_id);
	
	User findByemployeeId(int employeeId);
	
	User findByUserId(int userId);
	
	@Modifying
	@Transactional
	@Query("UPDATE User user SET user.project.projectId = :project_id WHERE user.userId = :userId")
    int updateProjectId(@Param("project_id") int project_id, @Param("userId") int userId);
	
	@Modifying
	@Transactional
	@Query("UPDATE User user SET user.task.taskId = :task_id WHERE user.userId = :userId")
    int updateTaskId(@Param("task_id") int task_id, @Param("userId") int userId);
	
	@Modifying
	@Transactional
	@Query("UPDATE User user SET user.activeFlag = :activeFlag WHERE user.userId = :userId")
    int updateUserStatus(@Param("activeFlag") String activeFlag,  @Param("userId") int userId);
	
}
