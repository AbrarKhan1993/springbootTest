package com.practice.mysqlcrud.service;

import com.practice.mysqlcrud.bean.common.ResponseBean;
import com.practice.mysqlcrud.model.Student;

public interface StudentService {
	public ResponseBean saveStudent(Student Student);
	public ResponseBean updateStudent(Student Student);
	public ResponseBean getStudentById(Long id);
	public ResponseBean getAllStudents();
}
