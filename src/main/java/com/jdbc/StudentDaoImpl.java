package com.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	NamedParameterJdbcTemplate jt;

	public void insert(Student student) {
		
		String query="insert into student values (:id,:marks,:name)";  
		  
		Map<String,Object> map=new HashMap<String,Object>();  
		map.put("id",student.getId());  
		map.put("name",student.getName());  
		map.put("marks",student.getMarks()); 
		             
		jt.execute(query,map,new PreparedStatementCallback() {  
		    public Object doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		        return ps.executeUpdate();  
		    }  
		});  
		
//		jt.update("insert into student(id, marks,name) VALUES (?, ?, ?)",
//	            student.getId(), student.getMarks(), student.getName());
	}
	
}