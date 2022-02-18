package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.Student;
import com.jdbc.StudentService;

public class MainLogic {

	public static void main(String args[]) {

		AbstractApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService st = (StudentService) ac.getBean("studentService");
		
        st.insert(new Student(304,450,"Keerthan"));
		//SpringJdbcTemplate sj =ac.getBean(SpringJdbcTemplate.class);
		//sj.select();
		
	}
	
}
