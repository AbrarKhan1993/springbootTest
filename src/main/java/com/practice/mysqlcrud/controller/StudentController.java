package com.practice.mysqlcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.mysqlcrud.bean.common.ResponseBean;
import com.practice.mysqlcrud.model.Student;
import com.practice.mysqlcrud.service.StudentService;



@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/student/")
public class StudentController {
	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	@PostMapping(path = "saveStudent")
	@ResponseBody
	public ResponseBean saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
		
	}
	@PostMapping(path = "updateStudent")
	@ResponseBody
	public ResponseBean updateStudent(@RequestBody Student student) {
	     return studentService.updateStudent(student);
	}
	
	@RequestMapping(value="getAllStudents" ,method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getAllStudents()  {
		return studentService.getAllStudents();
	}

	@RequestMapping(path ="/getStudentById/{ID}" )
	public ResponseBean getStudentById(@PathVariable("ID") Long id) {
		 return studentService.getStudentById(id);
	}

	
}
