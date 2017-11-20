package com.example.mvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.mvc.core.service.impl.Calculator;

public class CalculatorTest {

	@Mock
	private Calculator calculator;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAbs(){
		
		//to change the behavior of the abs function
		when(calculator.abs(-5)).thenReturn(5);
		
		int expected = 5;
		int actual =calculator.abs(-5);
		assertEquals(expected,actual);
	}

}
