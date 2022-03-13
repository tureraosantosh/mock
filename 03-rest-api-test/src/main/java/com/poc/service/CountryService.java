package com.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.dto.CountryResponse;
import com.poc.entity.Country;
import com.poc.repo.CountryRepo;

@Service
public class CountryService {

	@Autowired
	private CountryRepo countryRepo;

	public List<Country> getAllCountry() {
		return countryRepo.findAll();
	}

	public Country getCountryId(Long id) {
		return countryRepo.findById(id).get();
	}

	public Country getCountryByName(String countryName) {
		Country country = null;
		List<Country> findAll = countryRepo.findAll();
		for (Country con : findAll) {
			if (con.getCountryName().equalsIgnoreCase(countryName)) {
				country = con;
				break;
			}
		}
		return country;

	}

	public Long getMaxId() {

		return countryRepo.findAll().size() + 1L;
	}

	public Country addCountry(Country country) {
		return countryRepo.save(country);
	}

	public Country updateCountry(Country country) {
		return countryRepo.save(country);
	}

	public CountryResponse deleteCountry(Long id) {
		countryRepo.deleteById(id);
		CountryResponse response = new CountryResponse();
		response.setMsg("Country Deleted !!");
		response.setId(id);
		return response;
	}

}
