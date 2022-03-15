package com.poc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.dto.CountryResponse;
import com.poc.entity.Country;
import com.poc.service.CountryService;

@RestController
@RequestMapping("country")
public class CountryResource {

	@Autowired
	CountryService countryService;

	@GetMapping("/getcountries")
	public ResponseEntity<List<Country>> getCountries() {

		try {
			return new ResponseEntity<>(countryService.getAllCountry(), HttpStatus.FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/getcountry/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable("id") Long countryId) {
		try {
			Country country = countryService.getCountryId(countryId);
			return new ResponseEntity<>(country, HttpStatus.FOUND);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/getcountry")
	public ResponseEntity<Country> getCountryBycountryName(@RequestParam("countryname") String countryname) {

		try {
			Country country = countryService.getCountryByName(countryname);

			return new ResponseEntity<>(country, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addcountry")
	public Country getCountryBycountryName(@RequestBody Country country) {
		return countryService.addCountry(country);
	}

	@PostMapping("/updatecountry/{countryid}")
	public ResponseEntity<Country> getCountryBycountryName(@PathVariable("countryid") Long countryId,
			@RequestBody Country country) {

		Country existCountry = countryService.getCountryId(countryId);
		try {
			existCountry.setCountryName(country.getCountryName());
			existCountry.setCountryCapital(country.getCountryCapital());
			Country updateCountry = countryService.updateCountry(country);
			return new ResponseEntity<Country>(updateCountry, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Country>(HttpStatus.BAD_REQUEST);

		}

	}

	@DeleteMapping("/deletecountry/{id}")
	public ResponseEntity<CountryResponse> deleteCountryById(@PathVariable Long id) {
		try {
			CountryResponse countryResponse = countryService.deleteCountry(id);
			return new ResponseEntity<CountryResponse>(countryResponse, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return new ResponseEntity<CountryResponse>(HttpStatus.BAD_REQUEST);
		}

	}

}
