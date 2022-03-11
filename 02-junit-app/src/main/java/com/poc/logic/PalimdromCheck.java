package com.poc.logic;

public class PalimdromCheck {

	public boolean isPalimdrome(String str) {

		String reverse = "";

		int length = str.length();
		for (int i = length - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		if (str.equalsIgnoreCase(reverse)) {
			return true;
		}
		return false;
	}

}
