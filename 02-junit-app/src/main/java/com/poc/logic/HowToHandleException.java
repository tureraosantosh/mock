package com.poc.logic;

public class HowToHandleException {

	public static Integer convertToInt(String str) {
		if (str == null || str.trim().length() == 0) {
			throw new IllegalArgumentException("String must not be null or empt");
		}
		return Integer.valueOf(str);
	}

}
