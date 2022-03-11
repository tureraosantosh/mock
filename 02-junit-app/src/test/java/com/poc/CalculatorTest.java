package com.poc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.poc.logic.Calculator;

public class CalculatorTest {

	static Calculator cal = null;

	@BeforeAll
	public static void any() {

		cal = new Calculator();
	}

	@Test
	public void testAddition() {
		System.out.println("cal:: " + cal);
		int num1 = 90;
		int num2 = 10;
		Integer actual = cal.addition(num1, num2);
		Integer expeced = 100;
		assertEquals(expeced, actual);
	}

	@AfterAll
	public static void dest() {
		System.out.println("nulling object ");
		cal = null;
	}

}
