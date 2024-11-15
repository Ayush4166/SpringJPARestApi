package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dao.StudentDao;
import com.example.rest.entity.Student;

@RestController
public class StudentController {
	
	//CURD Create 
	@Autowired
	private StudentDao studentdao;
	@PostMapping("/students")
	public String addStudent(@RequestBody Student stud) {
		studentdao.save(stud);
		return "Student Added Succesfully";
	}
	//Curd read-single operation
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable Integer studentId) {
		return studentdao.findById(studentId);
	}
	//read all data
	@GetMapping("/students")
	public List<Student> getAllStudennts(){
		return studentdao.findAll();
	}
	
	//Curd Update
	@PutMapping("/students")
	public String updateStudent(@RequestBody Student stud) {
		studentdao.update(stud);
		return "Student Upated sucefully";
	}
	
	//Curd Delete
	@DeleteMapping("/students/{studentId}")
	public String DeleteStudent(@PathVariable Integer studentId) {
		studentdao.deleteById(studentId);
		return "Student Deleted by id:"+studentId+"\n Successfuly";
	}
	
	
}
