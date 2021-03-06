package com.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Person;
import com.example.support.CustomRepositoryFactoryBean;
@Controller
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass=CustomRepositoryFactoryBean.class)
public class DemoApplication {
	
	@RequestMapping("/")
	public String index(Model model){
		System.out.println("Hello /");
		Person single = new Person("aa",11);
		
		List<Person> people = new ArrayList<Person>();
		
		Person p1 = new Person("xx",11);
		Person p2 = new Person("yy",22);
		Person p3 = new Person("zz", 33);
		
		people.add(p1);
		people.add(p2);
		people.add(p3);
		
		model.addAttribute("singlePerson",single);
		model.addAttribute("people", people);
		
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	/*
	@Bean
	public EmbeddedServletContainerFactory servletContainer(){
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory(){
			@Override
			protected void postProcessContext(Context context){
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(httpConnector());
		return tomcat;
		
	}
	
	@Bean
	public Connector httpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(8443);
		
		return connector;
	}
	*/
}
