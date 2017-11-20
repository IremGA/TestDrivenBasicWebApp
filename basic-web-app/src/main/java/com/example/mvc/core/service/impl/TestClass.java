package com.example.mvc.core.service.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestClass {

	@RequestMapping("/test")
	public String test(){
		return "view";
	}
}
