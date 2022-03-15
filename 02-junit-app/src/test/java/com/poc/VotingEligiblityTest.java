package com.poc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.poc.logic.VotingEligbility;

public class VotingEligiblityTest {
	
	@Test
	public void testisEligible() {
		//calling method and passing value
		VotingEligbility eligbility=new VotingEligbility();
		
		//get actual result 
		boolean actual = eligbility.isEligible(16);
		//expectected result
		boolean expected=true;
		//verify acuaal and expected
		assertTrue(actual);
		
	}

}
