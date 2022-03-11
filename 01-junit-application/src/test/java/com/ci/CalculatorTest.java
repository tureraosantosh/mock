package com.ci;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAddition() {
		Calculator calc = new Calculator();
		Integer actualResult = calc.addition(20, 20);
		Integer expectedResult = 40;

		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testMultiply() {
		Calculator calc = new Calculator();
		int num1 = 2;
		int num2 = 3;
		Integer actual = calc.multiply(num1, num2);
		Integer expected = 6;
		assertEquals(expected, actual);

	}
}
