/**
 * @创建人：石永强
 * @创建时间：　2016年4月18日下午4:46:45
 * @类名：　SysRole
 * @说明：
 * @修改人：
 * @修改时间：
 * @修改说明
 */
package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SysRole {
	
	@Id
	@GeneratedValue
	private Long Id;
	private String name;
	private String roleDesc;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
}
