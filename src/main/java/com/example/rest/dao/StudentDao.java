package com.example.rest.dao;

import java.util.List;

import com.example.rest.entity.Student;

public interface StudentDao {
	
	public void save(Student student);
	
	public Student findById(Integer id);
	
	public List<Student> findAll();
	
	public void update(Student student);
	
	public void deleteById(Integer id);
}
