package com.poc.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PassengerInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long pId;
	private String name;
	private String email;
	private String source;
	private String destination;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private Date travelDate;
    private String pickupTime;
    private String arrivalTime;
    private double fare;
}
