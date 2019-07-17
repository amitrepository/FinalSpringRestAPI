package com.cts.task.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.task.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

	@Override
	List<Task> findAll();
	
	public <S extends Task> S save(S arg0);
	
	Task findByTaskName(String task_name);
	
	@Modifying
	@Transactional
	@Query("UPDATE Task task SET task.activeFlag = :activeFlag WHERE task.taskName = :taskName")
    int updateTask(@Param("activeFlag") String activeFlag, @Param("taskName") String taskName);
	
	List<Task> findByProject_ProjectName(String projectName);
}
