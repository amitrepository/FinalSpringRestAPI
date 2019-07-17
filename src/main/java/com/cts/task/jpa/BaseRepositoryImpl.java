package com.cts.task.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends
		SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

	private final EntityManager entityManager;

	public BaseRepositoryImpl(Class<T> domainClass,
			EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public T refreshData(T entity) {
		
		entityManager.refresh(entity);
		return entity;
	}

	

}
