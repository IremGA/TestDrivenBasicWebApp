package com.example.mvc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.mvc.core.controller.FitBitNotificationController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;

public class FitBitNotificationControllerTest {

	@InjectMocks
	private FitBitNotificationController fitBitNotificationController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(fitBitNotificationController).build();
		
	}
	
	@Test
	public void test() throws Exception{
		mockMvc.perform(get("/test")).andDo(print());
	}
	
	@Test
	public void reponseUserTest() throws Exception{
		mockMvc.perform(get("/responseUserWithResponseEntitiy")).andDo(print());
	}
	
	@Test
	public void reponseUserBodyTest() throws Exception{
		mockMvc.perform(get("/responseUserWithResponseBody")).andDo(print());
	}

	@Test
	public void postUserTest() throws Exception{
		mockMvc.perform(post("/postUser")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"step_count\":10000,\"heart_rate\":70,\"user_name\":\"Irem\",\"step_goal\":10000}"))
		.andExpect(jsonPath("$.step_count", Matchers.is(10000)))
		.andDo(print());
	}

}
