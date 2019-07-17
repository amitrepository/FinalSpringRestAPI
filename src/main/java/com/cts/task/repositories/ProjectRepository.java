package com.cts.task.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.task.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	@Override
	List<Project> findAll();
	
	public <S extends Project> S save(S arg0);
	
	Project findByProjectName(String project_name);
	
	Project findByProjectId(int projectId);
	

	@Modifying
	@Transactional
	@Query("UPDATE Project pro SET pro.activeFlag='N' where pro.projectId = :project_id")
    int deleteProject(@Param("project_id") int project_id);
	
}
