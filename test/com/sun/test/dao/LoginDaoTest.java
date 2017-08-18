package com.sun.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.sun.config.DataBaseConfig;
import com.sun.dao.LoginDao;
import com.sun.request.vo.LoginVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DataBaseConfig.class})
@EnableTransactionManagement
@Transactional
public class LoginDaoTest {

	 @Autowired
	 private LoginDao loginDao;
	
	 private LoginVO loginVO;

	@Test
	public void queryLoginInfoTest() {
		 if (loginDao!= null) {
			 System.out.println("loginDao is not null");
			 
		 }
		System.out.println("test");
	}

}
