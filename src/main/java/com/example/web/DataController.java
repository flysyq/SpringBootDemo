/**
 * 
 */
package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.PersonRepository;
import com.example.domain.*;
/**
 * @作者 admin
 * @时间 2016年4月13日 上午9:44:55
 * @类名 DataController.java
 * @类描述 
 * @修改记录
 * 1、修改人 2016年4月13日 上午9:44:55
 *   修改描述
 */
@RestController
public class DataController {
	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping("/auto")
	public Page<Person> auto(Person person){
		Page<Person> pagePeople = personRepository.findByAuto(person, new PageRequest(0,10));
		return pagePeople;
		
	}
}
