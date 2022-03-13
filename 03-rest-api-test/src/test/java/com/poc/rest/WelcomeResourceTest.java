package com.poc.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.poc.resource.WelcomeResource;
import com.poc.service.WelcomeService;

@WebMvcTest(value = WelcomeResource.class)
public class WelcomeResourceTest {

	@MockBean
	private WelcomeService welcomeService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testWelcome() throws Exception {
		when(welcomeService.welcome()).thenReturn("good evening all ");
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int actual = response.getStatus();
		int expected = 202;
		assertEquals(expected, actual);

	}

}
