package com.poc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.poc.logic.EvenOrOdd;

public class EvenOrOddTest {

//	@ParameterizedTest
//	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
//	public void testEvenOrOdd(String input, String expected) {
//		EvenOrOdd evn = new EvenOrOdd();
//		String actual = evn.evenOrOddNum(Integer.valueOf(input));
//		assertEquals(expected, actual);
//
//	}

	@ParameterizedTest
	@CsvFileSource(resources = "/data2.csv", numLinesToSkip = 1)
	public void testEvenOrOdd(String input, String expected) {
		EvenOrOdd evenOrOdd = new EvenOrOdd();
		String actual = evenOrOdd.evenOrOddNum(Integer.parseInt(input));
		assertEquals(expected, actual);
	}

}
