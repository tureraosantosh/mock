package com.poc.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.entity.Student;
import com.poc.resource.StudentResource;
import com.poc.service.StudentService;

@WebMvcTest(value = StudentResource.class)
public class StudentResourceTest {

	@MockBean
	private StudentService studentService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testAddStudent() throws Exception {
		// mocking
		when(studentService.addStudent(ArgumentMatchers.any())).thenReturn(true);

		// creating json object
		Student student = new Student(1L, "santosh", "turerao", "turerao@gmail.com");
		ObjectMapper mapper = new ObjectMapper();
		String studentJson = mapper.writeValueAsString(student);

		// generationg request
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addStudent")
				.contentType(MediaType.APPLICATION_JSON).content(studentJson);

		// triggering request
		ResultActions perform = mockMvc.perform(requestBuilder);
		// getting response
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		// asserting
		int actual = response.getStatus();
		assertEquals(200, actual);

	}

}
