package com.example.mvc.core.service.impl;

import com.example.core.model.User;
import com.example.mvc.core.service.FitBitNotificationInterface;

public class FitBit_Notification implements FitBitNotificationInterface {

	private String notificationMessage;

	
	private String getNotificationMessage() {
		return notificationMessage;
	}

	private void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	private void create_step_calculation_notification(User user) {

		int step_goal = user.getStep_goal();

		int step_count = user.getStep_count();

		if (step_goal > step_count) {

			setNotificationMessage("Keep move on!");

		} else if (step_goal == step_count) {
			setNotificationMessage("You have reached your target today! Well done!");

		}

	}

	private void create_HeartRateNotification(User user) {

		int heartRate = user.getHeart_rate();

		if (heartRate > 80 && heartRate < 110) {
			setNotificationMessage("Warming Up! You are burning fat");
		} else if (heartRate > 110) {
			setNotificationMessage("Cardio Time! Don't forget to cool down!");
		}
	}

	public String sendHeartRateNotificationMessage(User user) {
		create_HeartRateNotification(user);
		return getNotificationMessage();
	}

	public String sendStepCountNotificationMessage(User user) {
		create_step_calculation_notification(user);
		return getNotificationMessage();
	}

	@Override
	public String sendHeartRateNotificationMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendStepCountNotificationMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}
