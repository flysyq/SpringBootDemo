/**
 * @创建人：石永强
 * @创建时间：　2016年4月18日下午5:15:52
 * @类名：　SysUserRepository
 * @说明：
 * @修改人：
 * @修改时间：
 * @修改说明
 */
package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long>{

	SysUser findByUsername(String username);
}
