package com.poc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.dto.FlightBookingAck;
import com.poc.dto.FlightBookingRequest;
import com.poc.service.FlightBookingService;

@RestController
public class FlightBookResource {

	@Autowired
	private FlightBookingService bookingService;

	@PostMapping("/book")
	public FlightBookingAck bookFlight(@RequestBody FlightBookingRequest request) {

		return bookingService.bookFlightTicket(request);

	}

}
