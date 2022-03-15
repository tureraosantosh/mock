package com.poc.logic;

public class VotingEligbility {

	public boolean isEligible(int age) {

		if (age >= 18) {
			return true;
		} else {
			return false;
		}

	}

}
