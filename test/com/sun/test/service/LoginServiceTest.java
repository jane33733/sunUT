package com.sun.test.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sun.dao.LoginDao;
import com.sun.request.vo.LoginVO;
import com.sun.respose.vo.LoginInfoVO;
import com.sun.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/context-dispatcher.xml")
@WebAppConfiguration
public class LoginServiceTest {

	private static final Logger log = LoggerFactory.getLogger(LoginServiceTest.class);
	
	@InjectMocks
	@Autowired
	private LoginService loginService;
	
	@Mock
	@Autowired
	private LoginDao loginDao;
		
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void loginSuccess() {
				
		LoginInfoVO loginInfoVO = new LoginInfoVO();
		loginInfoVO.setIsExist(true);
		
		LoginVO loginVO = mock(LoginVO.class);
    	when(loginService.validateUser(loginVO)).thenReturn(loginInfoVO);
    	
	}
	
	@Test
	public void loginFail() {
			
		LoginVO loginVO = new LoginVO();
		loginVO.setAccount("noThisOne");
		loginVO.setPassword("wrongPassword");
		
		LoginInfoVO loginInfoVO = new LoginInfoVO();
		loginInfoVO.setIsExist(false);
		
    	when(loginService.validateUser(loginVO)).thenReturn(loginInfoVO);

	}

}
