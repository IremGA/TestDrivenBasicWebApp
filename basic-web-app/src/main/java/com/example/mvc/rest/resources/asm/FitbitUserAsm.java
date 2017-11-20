package com.example.mvc.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.example.core.model.User;
import com.example.mvc.rest.controller.FitBitUserController;
import com.example.mvc.rest.resources.FitBitUser;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Link;

public class FitbitUserAsm extends ResourceAssemblerSupport<User, FitBitUser> {

	public FitbitUserAsm(){
		
		super(FitBitUserController.class, FitBitUser.class);
		
	}

	@Override
	public FitBitUser toResource(User arg0) {
		
		FitBitUser fitBitUser = new FitBitUser();
		fitBitUser.setHeart_rate(arg0.getHeart_rate());
		fitBitUser.setUser_name(arg0.getUser_name());
		fitBitUser.setStep_goal(arg0.getStep_goal());
		fitBitUser.setStep_count(arg0.getStep_count());
		
		Link link = linkTo(methodOn(FitBitUserController.class).getFitBitUser(arg0.getUserID())).withSelfRel();
		//For the class based Request Mapping @change:Link link = linkTo(FitBitUserController.class).slash(arg0.getUserID()).withSelfRel();
		fitBitUser.add(link.withSelfRel());		
		return fitBitUser;
	}
	
	
}
