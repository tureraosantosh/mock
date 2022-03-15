package com.poc.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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

	@MockBean
	private EmployeeService employeeService;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testsaveEmployee() throws Exception {
		Employee employee = new Employee(1L, "santosh", "santosh@gmail.com", "tech lead", 1200L);
		
		when(employeeService.saveEmployee(employee)).thenReturn(employee);
		ObjectMapper mapper = new ObjectMapper();
		String employeeJson = mapper.writeValueAsString(employee);
		ResultActions perform = mockMvc.perform(post("/employee/save").
				content(employeeJson).contentType(MediaType.APPLICATION_JSON));
		
		//response getting
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int actual = response.getStatus();
		assertEquals(201, actual);

	}

}
