package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainLogic {

	public static void main(String args[]) {

		AbstractApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		SpringJdbcTemplate sjt = (SpringJdbcTemplate) ac.getBean("getSpringTemplate");
		sjt.select();
		//SpringJdbcTemplate sj =ac.getBean(SpringJdbcTemplate.class);
		//sj.select();
		
	}
	
}
