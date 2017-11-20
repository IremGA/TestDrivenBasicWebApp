package com.example.core.model;

public class User {

	Integer step_count;
	Integer heart_rate;
	String user_name;
	Integer step_goal;
	Long userID;
	
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Integer getStep_goal() {
		return step_goal;
	}
	public void setStep_goal(Integer step_goal) {
		this.step_goal = step_goal;
	}
	public Integer getStep_count() {
		return step_count;
	}
	public void setStep_count(Integer step_count) {
		this.step_count = step_count;
	}
	public Integer getHeart_rate() {
		return heart_rate;
	}
	public void setHeart_rate(Integer heart_rate) {
		this.heart_rate = heart_rate;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
	
}
