package com.poc.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.poc.entity.Country;

@DataJpaTest
public class CountryRepoTest {

	@Autowired
	CountryRepo countryRepo;

	@Test
	public void saveCountry() {
		Country country = new Country(1L, "India", "Delhi");
		countryRepo.save(country);
		assertThat(country.getId()).isGreaterThan(0);
	}

}
