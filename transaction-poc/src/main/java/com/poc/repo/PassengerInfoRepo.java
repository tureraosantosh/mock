package com.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.entities.PassengerInfo;

public interface PassengerInfoRepo  extends JpaRepository<PassengerInfo, Long>{

}
