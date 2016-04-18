/**
 * @创建人：石永强
 * @创建时间：　2016年4月18日下午5:28:53
 * @类名：　WebMvcConfig
 * @说明：
 * @修改人：
 * @修改时间：
 * @修改说明
 */
package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}
	
}
