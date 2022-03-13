package com.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.entity.Student;
import com.poc.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	public boolean addStudent(Student student) {
		Student save = studentRepo.save(student);
		return save != null;
	}

}
