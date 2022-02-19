package com.spring;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.jdbc.Student;

@Component
public class SpringJdbcTemplate {
	//JdbcTemplate jt;

	NamedParameterJdbcTemplate njt;

	//	public void setJt(JdbcTemplate jt) {
	//		this.jt = jt;
	//	}
	//	public JdbcTemplate getJt() {
	//		return jt;
	//	}
	//	public void select() {
	//
	//		List list = jt.queryForList("select * from student");
	//		Iterator itr = list.iterator();
	//		while(itr.hasNext()) {
	//			System.out.println(itr.next());
	//		}
	//	}

	public NamedParameterJdbcTemplate getNjt() {
		return njt;
	}

	public void setNjt(NamedParameterJdbcTemplate njt) {
		this.njt = njt;
	}

	public void select() {

		String sql = "select * from student";

		Student result = njt.query(sql,new ResultSetExtractor<Student>() {

			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Student st = new Student();
					st.setId(rs.getInt("id"));
					st.setName(rs.getString("name"));
					st.setMarks(rs.getInt("marks"));
					System.out.println(st);
				}
				return null;
			}
		});
	}

}
