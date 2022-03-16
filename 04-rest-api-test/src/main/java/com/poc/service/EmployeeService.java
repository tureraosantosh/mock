package com.poc.service;

import java.util.List;

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

	public List<Employee> getAllEmployee() {

		return employeeRepo.findAll();
	}

	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(id).get();
	}

}
