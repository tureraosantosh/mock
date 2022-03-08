package com.poc.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.poc.dto.FlightBookingAck;
import com.poc.dto.FlightBookingRequest;
import com.poc.entities.PassengerInfo;
import com.poc.entities.PaymentInfo;
import com.poc.repo.PassengerInfoRepo;
import com.poc.repo.PaymentInfoRepo;
import com.poc.utility.PaymentUtils;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerInfoRepo passengerInfoRepo;
	@Autowired
	private PaymentInfoRepo paymentInfoRepo;

	@Transactional(propagation=Propagation.REQUIRED)
	public FlightBookingAck bookFlightTicket(FlightBookingRequest request) {
		PassengerInfo passengerInfo = insertPassengerInfo(request);
		insertPayment(request, passengerInfo);
		return new FlightBookingAck("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString());
	}

	@Transactional(propagation=Propagation.REQUIRED)
	private void insertPayment(FlightBookingRequest request, PassengerInfo passengerInfo) {
		PaymentInfo paymentInfo = request.getPaymentInfo();
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		paymentInfo.setPassengerId(passengerInfo.getPId());
		paymentInfo.setAmount(passengerInfo.getFare());
		paymentInfoRepo.save(paymentInfo);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	private PassengerInfo insertPassengerInfo(FlightBookingRequest request) {
		PassengerInfo passengerInfo = request.getPassengerInfo();
		passengerInfoRepo.save(passengerInfo);
		return passengerInfo;
	}

}
