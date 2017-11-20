package com.example.mvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.mvc.core.service.UserInterface;
import com.example.mvc.core.service.impl.FitBit_NotificationFotTest;

public class Test_FitBit_Notification {

	@Mock
	private UserInterface user_Interface;
	
	//User_Interface bean has been injected to FitBit_Notification bean
	@InjectMocks
	private FitBit_NotificationFotTest fitbitNotification;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testHeartRateNotificationWhenHeartRateValueBetween80and110(){
		
		//to change the behavior of the abs function
		when(user_Interface.getHeartRate()).thenReturn(100);
		
		assertEquals("Warming Up! You are burning fat",fitbitNotification.sendHeartRateNotificationMessage());
	}
	
	@Test
	public void testHeartRateNotificationWhenHeartRateValueGreaterThan110(){
		
		//to change the behavior of the abs function
		when(user_Interface.getHeartRate()).thenReturn(170);
		
		assertEquals("Cardio Time! Don't forget to cool down!",fitbitNotification.sendHeartRateNotificationMessage());
	}
	
	@Test
	public void testStepNotificationWhenStepValueLessThanTarget(){
		
		//to change the behavior of the abs function
		when(user_Interface.getStepGoal()).thenReturn(10000);
		when(user_Interface.countSteps()).thenReturn(9000);
		
		assertEquals("Keep move on!",fitbitNotification.sendStepCountNotificationMessage());
	}
	
	@Test
	public void testStepNotificationWhenStepValueEqualsWithTarget(){
		
		//to change the behavior of the abs function
		when(user_Interface.getStepGoal()).thenReturn(10000);
		when(user_Interface.countSteps()).thenReturn(10000);
		
		assertEquals("You have reached your target today! Well done!",fitbitNotification.sendStepCountNotificationMessage());
	}


}
