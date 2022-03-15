package com.poc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.entity.Employee;
import com.poc.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		
		Employee savedEmployee = employeeService.saveEmployee(employee);
		
		if (savedEmployee == null) {
			return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}

}
