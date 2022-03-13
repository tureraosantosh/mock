package com.poc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.poc.entity.Country;
import com.poc.repo.CountryRepo;

@SpringBootTest(classes = { CountryService.class })
public class CountryServiceTest {

	@Mock
	CountryRepo countryRepo;

	@InjectMocks
	CountryService countryService;

	@Test
	@Order(1)
	public void testGetAllCountries() {
		List<Country> countries = Arrays.asList(new Country(1L, "India", "Delhi"),
				new Country(2L, "Bangladesh", "Dhaka"), new Country(3L, "America", "New York"));
		when(countryRepo.findAll()).thenReturn(countries);
		int actual = countryService.getAllCountry().size();
		int expected = countries.size();
		assertEquals(expected, actual);

	}
}
