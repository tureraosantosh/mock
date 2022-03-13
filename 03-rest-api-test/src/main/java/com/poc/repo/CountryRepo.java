package com.poc.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Serializable> {

}
