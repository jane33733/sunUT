package com.sun.test.service;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sun.request.vo.LoginVO;
import com.sun.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-service.xml",
//"classpath:spring-mapper-test.xml"})
@WebAppConfiguration
public class LoginServiceTest {

	private static final Logger log = LoggerFactory.getLogger(LoginServiceTest.class);
	
	@InjectMocks
	@Autowired
	private LoginService loginService;
	
	private MockMvc mockMvc;
	
	@Test
	public void test() {
		
		LoginVO loginVO = new LoginVO();
		loginVO.setAccount("haha");
		loginVO.setPassword("123");
		


		//這個看起來是驗證RESTFUL API?
		
        try {
			mockMvc.perform(MockMvcRequestBuilders
			        .get("url")
			        .accept(MediaType.APPLICATION_JSON))
			        .andDo(mvcResult -> Assert.assertEquals(loginVO, loginService.validateUser(loginVO) ) );
		} catch (Exception e) {
			log.error("mockMvc error : {}",e);
			e.printStackTrace();
		}
		
		loginService.validateUser(loginVO);
		fail("Not yet implemented");
	}

}
