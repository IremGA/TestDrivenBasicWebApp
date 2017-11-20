package com.example.mvc.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.core.model.User;
import com.example.mvc.core.service.FitBitUserInterface;
import com.example.mvc.rest.controller.FitBitUserController;


public class FitBitUserControllerTest {

	@InjectMocks
	private FitBitUserController fitBitUserController;
	
	@Mock
	private FitBitUserInterface fitBitUserInterface;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(fitBitUserController).build();
		
	}
	
	@Test
	public void getFitBitUserTest() throws Exception{
		
		User user = new User();
		user.setUserID(1L);
		user.setHeart_rate(110);
		user.setUser_name("Irem");
		user.setStep_goal(10000);
		user.setStep_count(5000);
		
		when(fitBitUserInterface.findUser(1L)).thenReturn(user);
		
		mockMvc.perform(get("/rest/getFitBitUser/1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.links[*].href", Matchers.hasItem(Matchers.endsWith("/getFitBitUser/1"))))
				.andExpect(jsonPath("$.step_goal",  Matchers.is(user.getStep_goal())));
	}
	
	@Test
	public void getFitBitUserTestFail() throws Exception{
		
		
		when(fitBitUserInterface.findUser(1L)).thenReturn(null);
		
		mockMvc.perform(get("/rest/getFitBitUser/1"))
				.andDo(print())
				.andExpect(status().isNotFound());
				}
}
