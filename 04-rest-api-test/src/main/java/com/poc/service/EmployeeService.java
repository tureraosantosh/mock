package com.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.entity.Employee;
import com.poc.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

}
