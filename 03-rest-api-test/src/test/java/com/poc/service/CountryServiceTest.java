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

@SpringBootTest(classes = { CountryServiceTest.class })
public class CountryServiceTest {
	List<Country> countries = Arrays.asList(
			new Country(1L, "India", "Delhi"), new Country(2L, "Bangladesh", "Dhaka"),
			new Country(3L, "America", "New York"));

	@Mock
	CountryRepo countryRepo;

	@InjectMocks
	CountryService countryService;

	@Test
	@Order(3)
	public void testGetAllCountries() {

		when(countryRepo.findAll()).thenReturn(countries);
		int actual = countryService.getAllCountry().size();
		int expected = countries.size();
		assertEquals(expected, actual);

	}

	@Test
	@Order(2)
	public void testGetCountryById() {
		Long id = 2L;
		when(countryRepo.findAll()).thenReturn(countries);
		Country country = countryService.getCountryId(id);
		assertEquals(id, country.getId());

	}
	
	@Test
	@Order(1)
	public void testGetCountryByName() {
		String countryName = "India";
		when(countryRepo.findAll()).thenReturn(countries);
		Country country = countryService.getCountryByName(countryName);
		assertEquals(countryName, country.getCountryName());

	}
}
