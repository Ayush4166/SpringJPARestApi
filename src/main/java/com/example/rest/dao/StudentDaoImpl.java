package com.example.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.rest.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private EntityManager entitymanager;
	@Transactional
	@Override
	public void save(Student student) {
		entitymanager.persist(student);
		
	}
	
	//Read operation
	@Override
	public Student findById(Integer id) {
		
		return entitymanager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query=entitymanager.createQuery("From Student",Student.class);
		List<Student> students=query.getResultList();
		return students;
	}

	@Override
	@Transactional
	public void update(Student student) {
		entitymanager.merge(student);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		Student student=entitymanager.find(Student.class, id);
		entitymanager.remove(student);
		
	}	

}
