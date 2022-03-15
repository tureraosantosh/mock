package com.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
