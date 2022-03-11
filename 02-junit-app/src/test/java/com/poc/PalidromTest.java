package com.poc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.poc.logic.PalimdromCheck;

public class PalidromTest {

	// @valuesource
	@ParameterizedTest
	@ValueSource(strings = { "madam", "liril" })
	public void testIsPalimdrome(String str) {
		PalimdromCheck pal = new PalimdromCheck();
		boolean actual = pal.isPalimdrome(str);
		assertTrue(actual);

	}

	
}
