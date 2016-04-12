/**
 * 
 */
package com.example.support;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @作者 admin
 * @时间 2016年4月12日 下午5:25:43
 * @类名 CustomRepository.java
 * @类描述 
 * @修改记录
 * 1、修改人 2016年4月12日 下午5:25:43
 *   修改描述
 */
@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
	Page<T> findByAuto(T example, Pageable pageable);
	
}
