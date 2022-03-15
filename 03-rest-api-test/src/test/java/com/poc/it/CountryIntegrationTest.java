package com.poc.it;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest

public class CountryIntegrationTest {

	
	
	@Test
	@Order(2)
	public void getAllCountries() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:9090/country/getcountries", String.class);
		String body = responseEntity.getBody();
		
		System.out.println("Body "+body);
		

	}
}
