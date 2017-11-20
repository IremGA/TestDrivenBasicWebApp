package com.example.mvc.core.service.impl;

import com.example.core.model.User;
import com.example.mvc.core.service.FitBitNotificationInterface;
import com.example.mvc.core.service.UserInterface;

public class FitBit_NotificationFotTest implements FitBitNotificationInterface {

	private String notificationMessage;
	private UserInterface user_interface;

	public FitBit_NotificationFotTest(UserInterface user_Interface) {

		this.user_interface = user_Interface;
	}

	private String getNotificationMessage() {
		return notificationMessage;
	}

	private void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	private void create_step_calculation_notification() {

		int step_goal = user_interface.getStepGoal();

		int step_count = user_interface.countSteps();

		if (step_goal > step_count) {

			setNotificationMessage("Keep move on!");

		} else if (step_goal == step_count) {
			setNotificationMessage("You have reached your target today! Well done!");

		}

	}

	private void create_HeartRateNotification() {

		int heartRate = user_interface.getHeartRate();

		if (heartRate > 80 && heartRate < 110) {
			setNotificationMessage("Warming Up! You are burning fat");
		} else if (heartRate > 110) {
			setNotificationMessage("Cardio Time! Don't forget to cool down!");
		}
	}

	public String sendHeartRateNotificationMessage() {
		create_HeartRateNotification();
		return getNotificationMessage();
	}

	public String sendStepCountNotificationMessage() {
		create_step_calculation_notification();
		return getNotificationMessage();
	}

	@Override
	public String sendHeartRateNotificationMessage(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendStepCountNotificationMessage(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
