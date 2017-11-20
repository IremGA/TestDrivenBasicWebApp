package com.example.mvc.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.core.model.User;
import com.example.mvc.core.service.FitBitNotificationInterface;

@Controller
public class FitBitNotificationController {

	FitBitNotificationInterface fitbitNotification;
	
	@RequestMapping("/test")
	public String getHeartRateNotification(){
		return "view";
	}
	
	@RequestMapping("/responseUserWithResponseEntitiy")
	public ResponseEntity<Object> getResponseEntry(){
		
		User user = new User();
		user.setStep_goal(10000);
		user.setStep_count(2490);
		user.setUser_name("Irem");
		user.setHeart_rate(120);
		
		return new ResponseEntity<Object>(user, HttpStatus.OK);
		
	}
	
	@RequestMapping("/responseUserWithResponseBody")
	public @ResponseBody User responseUserWithResponseEntitiy(){
		
		User user = new User();
		user.setStep_goal(10000);
		user.setStep_count(10000);
		user.setUser_name("Irem");
		user.setHeart_rate(70);
		
		return user;
		
	}
	
	@RequestMapping(value="/postUser", method=RequestMethod.POST)
	public @ResponseBody User postUser(@RequestBody User user){
		
		return user;
		
	}
}
