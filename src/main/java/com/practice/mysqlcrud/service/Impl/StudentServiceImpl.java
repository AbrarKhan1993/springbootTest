package com.practice.mysqlcrud.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.mysqlcrud.bean.common.ResponseBean;
import com.practice.mysqlcrud.constant.Status;
import com.practice.mysqlcrud.model.Student;
import com.practice.mysqlcrud.repository.StudentRepository;
import com.practice.mysqlcrud.service.StudentService;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	

	@Override
	public ResponseBean saveStudent(Student student) {
		try {
			if(student==null) {
				return ResponseBean.builder().status(Status.FAIL).message("student Is Empty Can be saved").build();
			}
			Student bean = studentRepository.save(student);
			return ResponseBean.builder().status(Status.SUCCESS).response(bean).build();
		} catch (Exception e) {
			return ResponseBean.builder().message("something went wrong").status(Status.FAIL).build();
		}
	}

	@Override
	public ResponseBean updateStudent(Student student) {
		try {
			Optional<Student> findById = studentRepository.findById(student.getId());
			if (findById == null) {
				return ResponseBean.builder().message("please provid valid Id").status(Status.FAIL).build();
			}
			Student bean = studentRepository.save(student);
			return ResponseBean.builder().status(Status.SUCCESS).response(bean).build();
		} catch (Exception e) {
			return ResponseBean.builder().message("something went wrong").status(Status.FAIL).build();
		}
	}

	@Override
	public ResponseBean getStudentById(Long id) {
		try {
			if (id == null) {
				return ResponseBean.builder().message("please provid Id").status(Status.FAIL).build();
			}
			Optional<Student> findById = studentRepository.findById(id);
			if (findById == null) {
				return ResponseBean.builder().message("please provid valid Id").status(Status.FAIL).build();
			}
			return ResponseBean.builder().status(Status.SUCCESS).response(findById.get()).build();
		} catch (Exception e) {
			return ResponseBean.builder().message("something went wrong").status(Status.FAIL).build();
		}
	}

	@Override
	public ResponseBean getAllStudents() {
		try {
			 List<Student> studentList = studentRepository.findAll();
			return ResponseBean.builder().status(Status.SUCCESS).response(studentList).build();
		} catch (Exception e) {
			return ResponseBean.builder().message("something went wrong").status(Status.FAIL).build();
		}
	}
	
	
}
