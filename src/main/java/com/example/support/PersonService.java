/**
 * @作者 admin
 * @时间 2016年4月14日 下午1:36:32
 * @类名 PersonService.java
 * @类描述 
 * @修改记录
 * 1、修改人 2016年4月14日 下午1:36:32
 *   修改描述
 */
package com.example.support;

import java.util.List;

import com.example.data.Person;

public interface PersonService {
	
	List<Person> getList(Integer page, Integer pageNum,String address,String name);
	
}
