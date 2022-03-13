package com.poc.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Serializable> {

}
