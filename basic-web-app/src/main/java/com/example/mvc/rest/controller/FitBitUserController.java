package com.example.mvc.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.core.model.User;
import com.example.mvc.core.service.FitBitUserInterface;
import com.example.mvc.rest.resources.FitBitUser;
import com.example.mvc.rest.resources.asm.FitbitUserAsm;

@Controller
//For the class based Request Mapping @change: @RequestMapping(value="/rest/getFitBitUser")
public class FitBitUserController {

	
	private FitBitUserInterface fitBitUserInterface;
	
	
	public FitBitUserController(FitBitUserInterface fitBitUserInterface) {
		
		this.fitBitUserInterface = fitBitUserInterface;
	}
	
	//For the class based Request Mapping @change:@RequestMapping(value="/{userID}", method= RequestMethod.GET)
	@RequestMapping(value="/rest/getFitBitUser/{userID}", method= RequestMethod.GET)
	public ResponseEntity<FitBitUser> getFitBitUser(@PathVariable Long userID){
		
		User user = fitBitUserInterface.findUser(userID);
		
		if(user!=null){
			FitBitUser fitBitUser = new FitbitUserAsm().toResource(user);
			return new ResponseEntity<FitBitUser>(fitBitUser, HttpStatus.OK);
		}else{
			return new ResponseEntity<FitBitUser>(HttpStatus.NOT_FOUND);
		}
		
	} 

}
