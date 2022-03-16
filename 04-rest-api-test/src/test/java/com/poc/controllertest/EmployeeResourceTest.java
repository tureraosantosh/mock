package com.poc.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.entity.Employee;
import com.poc.resource.EmployeeResource;
import com.poc.service.EmployeeService;

@WebMvcTest(value = EmployeeResource.class)
public class EmployeeResourceTest {

	// 1
	@MockBean
	private EmployeeService employeeService;

	// 2
	@Autowired
	MockMvc mockMvc;

	List<Employee> employees = Arrays.asList(new Employee(1L, "rahul", "rahul@gmail.com", "software eng", 60000L),
			new Employee(2L, "raj", "rahul@gmail.com", "software eng", 60000L),
			new Employee(3L, "rajan", "rahul@gmail.com", "software eng", 60000L)

	);

	@Test
	public void testGetEmployeeById() throws Exception {

		Employee employee = new Employee(1L, "santosh", "santosh@gmail.com", "tech lead", 1200L);

		when(employeeService.getEmployeeById(1L)).thenReturn(employee);

		Long countryId = 1L;
		ResultActions perform = mockMvc.perform(get("/employee/employeeId/{id}", countryId));

		MvcResult andReturn = perform.andReturn();

		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();

		assertEquals(302, status);

	}

	@Test
	public void testGetAllEmployees() throws Exception {
		when(employeeService.getAllEmployee()).thenReturn(employees);

		ResultActions perform = mockMvc.perform(get("/employee/employees"));
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
		String body = response.getContentAsString();
		System.out.println(body);
		assertEquals(200, status);

	}

//3
	@Test
	public void testsaveEmployee() throws Exception {
		Employee employee = new Employee(1L, "santosh", "santosh@gmail.com", "tech lead", 1200L);

		// 4
		when(employeeService.saveEmployee(employee)).thenReturn(employee);

		ObjectMapper mapper = new ObjectMapper();
		String employeeJson = mapper.writeValueAsString(employee);

		// 5

		ResultActions perform = mockMvc
				.perform(post("/employee/save").content(employeeJson).contentType(MediaType.APPLICATION_JSON));

		// response getting
		/// 6
		MvcResult mvcResult = perform.andReturn();

		// 7
		MockHttpServletResponse response = mvcResult.getResponse();

		// assertu 8
		int actual = response.getStatus();
		assertEquals(201, actual);

	}

}
