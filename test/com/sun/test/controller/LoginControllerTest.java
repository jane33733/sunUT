package com.sun.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.controller.LoginController;
import com.sun.request.vo.LoginVO;
import com.sun.respose.vo.LoginInfoVO;
import com.sun.service.LoginService;
import static org.mockito.Mockito.when; 

import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;




@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration(locations = {"/WebContent/WEB-INF/context-dispatcher.xml"})

//@ContextConfiguration(locations = {"file:WebContent/WEB-INF/context-dispatcher.xml","file:WebContent/WEB-INF/applicationContext.xml"})

@ContextConfiguration("file:WebContent/WEB-INF/context-dispatcher.xml")
	//"file:WebContent/WEB-INF/applicationContext.xml",
	//"file:WebContent/WEB-INF/spring-views.xml"
//	})



public class LoginControllerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginControllerTest.class);
	private MockMvc mockMvc;

	@Mock
	@Autowired
	private LoginService mockloginService;
	
		
	@InjectMocks
	@Autowired
	private LoginController loginController;
	 

	 @Before
	 public void setup() {
		 //mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		 
		 mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
		 MockitoAnnotations.initMocks(this);
	 }
	    

	@Test
	public void testloginValidateSucess() throws Exception{
		
//		LoginVO mockloginVO = new LoginVO();
//		mockloginVO.setAccount("haha");
//		mockloginVO.setPassword("123"); 
		
		LoginInfoVO mockloginInfoVO = new LoginInfoVO();
		mockloginInfoVO.setAccount("haha");
		mockloginInfoVO.setAccountId("1");
		mockloginInfoVO.setUserId("001");
		mockloginInfoVO.setUserName("張韶涵");
		mockloginInfoVO.setIsExist(true);
		
		
		//Mockito cannot mock static method:
		//when(LoginVO.getInstance(mockRequest)).thenReturn(mockloginVO);
		
		
		//when(mockloginService.validateUser(mockloginVO)).thenReturn(mockloginInfoVO);
		when(mockloginService.validateUser(any(LoginVO.class))).thenReturn(mockloginInfoVO);


		mockMvc.perform(post("/login/validate")
	    .param( "account", "haha" )
	    .param( "password", "123" ))
	    .andDo(print())
	    .andExpect( redirectedUrl( "pages/feature/productInfo.jsp" ))
		.andExpect(content().string("false"));
	}
	
	
	@Test
	public void testloginValidateIsExistFail() throws Exception{
		
		LoginInfoVO mockloginInfoVO = new LoginInfoVO();
		mockloginInfoVO.setIsExist(false);
		
		when(mockloginService.validateUser(any(LoginVO.class))).thenReturn(mockloginInfoVO);
		
		mockMvc.perform(post("/login/validate")
	    .param( "account", "haha" )
	    .param( "password", "123" ))
		.andDo(print())
	    .andExpect(redirectedUrl( "\\pages\\error\\errorSimple.jsp" ))
		.andExpect(content().string("false"));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testloginValidateException() throws Exception{
			
		when(mockloginService.validateUser(any(LoginVO.class))).thenReturn(null);
		
	    mockMvc.perform(post("/login/validate")
	    .param( "account", "haha" )
	    .param( "password", "123" ))
	    .andDo(print())
	    //.andExpect(status().isNotFound());
	    .andExpect(content().string("false"));
	}
}
