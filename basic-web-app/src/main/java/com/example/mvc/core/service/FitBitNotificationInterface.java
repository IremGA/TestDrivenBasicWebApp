package com.example.mvc.core.service;

import com.example.core.model.User;

public interface FitBitNotificationInterface {

	public String sendHeartRateNotificationMessage();
	public String sendStepCountNotificationMessage();
	public String sendHeartRateNotificationMessage(User user);
	public String sendStepCountNotificationMessage(User user);
	
}
