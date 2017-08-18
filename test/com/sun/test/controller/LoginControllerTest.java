package com.sun.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.web.context.WebApplicationContext;
//import org.mockito.MockitoAnnotations;



import com.sun.service.LoginService;




@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:WebContent/WEB-INF/context-dispatcher.xml")


public class LoginControllerTest {

	protected MockMvc mockMvc;

	@Autowired
	private LoginService loginService;
	
	@Autowired
    private WebApplicationContext wac;


	 @Before
	 public void setup() {
		 mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		 //MockitoAnnotations.initMocks(this);
	 }
	    

	
	@Test
	public void testloginValidateSucess(){
		
		
		//MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletRequest mockReq = new MockHttpServletRequest("POST", "/login/validate");
		
		mockReq.addParameter("account", "haha");
		mockReq.addParameter("password", "123");
			  
	    MockHttpServletResponse response = new MockHttpServletResponse();
	    
	    //mockMvc.perform(post("/login/validate")).
	    //andExpect( redirectedUrl( "pages/feature/productInfo.jsp" );

		
	}
}
