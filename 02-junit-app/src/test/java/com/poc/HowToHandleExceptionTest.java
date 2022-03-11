package com.poc;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.poc.logic.HowToHandleException;

public class HowToHandleExceptionTest {

	@Test
	public void testConvertToInt() {
		String str = null;

		assertThrows(IllegalArgumentException.class, () -> HowToHandleException.convertToInt(str));
	}

}
