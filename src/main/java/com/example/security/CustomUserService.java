/**
 * @创建人：石永强
 * @创建时间：　2016年4月18日下午5:23:21
 * @类名：　CustomUserService
 * @说明：
 * @修改人：
 * @修改时间：
 * @修改说明
 */
package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.dao.SysUserRepository;
import com.example.domain.SysUser;

public class CustomUserService implements UserDetailsService {

	@Autowired
	SysUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = userRepository.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		return user;
	}

}
