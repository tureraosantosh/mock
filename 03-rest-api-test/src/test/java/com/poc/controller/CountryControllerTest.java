package com.poc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.poc.entity.Country;
import com.poc.resource.CountryResource;
import com.poc.service.CountryService;

@WebMvcTest(value = { CountryResource.class })
public class CountryControllerTest {

	List<Country> countries = Arrays.asList(new Country(1L, "India", "Delhi"), new Country(2L, "India", "Delhi"),
			new Country(3L, "India", "Delhi"), new Country(4L, "India", "Delhi"), new Country(5L, "India", "Delhi")

	);

	@Autowired
	MockMvc mockMvc;

	@MockBean
	CountryService countryService;

	@Test
	@Order(1)
	public void testGetAllCountries() throws Exception {

		// mock service layer
		when(countryService.getAllCountry()).thenReturn(countries);

//		mockMvc.perform(get("/country/getcountries"))
		// create request url
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/country/getcountries");
//		//trigger controller
		ResultActions perform = mockMvc.perform(requestBuilder);
//		
//		//get the result
		MvcResult mvcResult = perform.andReturn();
//		
//		//get the response
		MockHttpServletResponse response = mvcResult.getResponse();
		int actual = response.getStatus();
		assertEquals(302, actual);

	}

}
