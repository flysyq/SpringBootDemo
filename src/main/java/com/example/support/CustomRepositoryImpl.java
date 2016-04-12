/**
 * 
 */
package com.example.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import static com.example.specs.CustomerSpecs.*;
/**
 * @作者 admin
 * @时间 2016年4月12日 下午5:29:10
 * @类名 CustomRepositoryImpl.java
 * @类描述 
 * @修改记录
 * 1、修改人 2016年4月12日 下午5:29:10
 *   修改描述
 */
public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID> {

	private final EntityManager entityManager;
	
	public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public Page<T> findByAuto(T example, Pageable pageable){
		return findAll(byAuto(entityManager, example), pageable);
	}
}
