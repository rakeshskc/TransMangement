package com.skc.transaction.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import com.skc.transaction.bl.Calculator;

public class CalculatorTest {

	private static final String LINUX = null;
	private static final String MAC = null;
	private Calculator cal;

	@BeforeEach
	void setUp() {
		cal = new Calculator();
		System.out.println("Before each method");
	}

	@Test
	@DisplayName("Simple multiplication should work")
	@RepeatedTest(10)	
	@EnabledOnOs({ OS.WINDOWS })
	void runOnWindows() {
		assertEquals(15, cal.multiply(3, 1));
	}
	
	@Test
	@DisplayName("Simple multiplication should work")
	@RepeatedTest(1)	
	@EnabledOnOs({ OS.LINUX })
	void runOnOtherThanWindowsOs() {
		assertEquals(15, cal.multiply(3, 1));
	}
	
	
}
