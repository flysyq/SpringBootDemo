/**
 * 
 */
package com.example.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 * @作者 admin
 * @时间 2016年4月13日 上午9:31:27
 * @类名 CustomRepositoryFactoryBean.java
 * @类描述 
 * @修改记录
 * 1、修改人 2016年4月13日 上午9:31:27
 *   修改描述
 */
public class CustomRepositoryFactoryBean<T extends JpaRepository<S, ID>,S, ID extends Serializable> extends JpaRepositoryFactoryBean<T, S, ID> {

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new CustomRepositoryFactory(entityManager);
	}
	
	private static class CustomRepositoryFactory extends JpaRepositoryFactory{

		public CustomRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
		}

		/* (non-Javadoc)
		 * @see org.springframework.data.jpa.repository.support.JpaRepositoryFactory#getTargetRepository(org.springframework.data.repository.core.RepositoryInformation, javax.persistence.EntityManager)
		 */
		@Override
		@SuppressWarnings({"unchecked"})
		protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(
				RepositoryInformation information, EntityManager entityManager) {
			return new CustomRepositoryImpl<T, ID>((Class<T>) information.getDomainType(),entityManager);
		}

		/* (non-Javadoc)
		 * @see org.springframework.data.jpa.repository.support.JpaRepositoryFactory#getRepositoryBaseClass(org.springframework.data.repository.core.RepositoryMetadata)
		 */
		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return CustomRepositoryImpl.class;
		}
		
		
	}

}
