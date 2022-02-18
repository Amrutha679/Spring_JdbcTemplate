package com.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
    public StudentDao studentDao;

	@Transactional
	public void insert(Student student) {
		this.studentDao.insert(student);
		
	}

}

