package com.cts.task.jpa;
import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

public class BaseRepositoryFactory<T, I extends Serializable> extends
		JpaRepositoryFactory {

	@PersistenceContext
	private final EntityManager em;

	public BaseRepositoryFactory(EntityManager em) {
		super(em);
		this.em = em;
	}


	@SuppressWarnings("unchecked")
	@Override
	protected Object getTargetRepository(RepositoryInformation metadata) {
		
		return new BaseRepositoryImpl<T,I>((Class<T>)metadata.getDomainType(), em);
	}

	@Override
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
		return BaseRepositoryImpl.class;
	}

}
