package com.spring;

import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class SpringJdbcTemplate {
JdbcTemplate jt;

public void setJt(JdbcTemplate jt) {
	this.jt = jt;
}

public void select() {
	
	List list = jt.queryForList("select * from student");
	Iterator itr = list.iterator();
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}
	
	}
}
