package com.sun.test.dao;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.sun.config.DataBaseConfig;
import com.sun.dao.LoginDao;
import com.sun.request.vo.LoginVO;
import com.sun.respose.vo.LoginInfoVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DataBaseConfig.class })
@EnableTransactionManagement
@Transactional
public class LoginDaoTest {

	@Autowired
	private LoginDao loginDao;

	private LoginVO loginVO;

	@Test
	@Rollback(true)
	public void queryLoginInfoTest() {

		loginVO = new LoginVO();
		loginVO.setAccount("haha");
		loginVO.setPassword("123");
		LoginInfoVO info = loginDao.queryLoginInfo(loginVO);
		assertNotNull(info);
		assertEquals(info.getAccount(), loginVO.getAccount());

		System.out.println("queryLoginInfoTest done");
	}
	
	@Test
	@Rollback(true)
	public void queryLoginFailTest() {

		loginVO = new LoginVO();
		loginVO.setAccount("william");
		loginVO.setPassword("123");
		LoginInfoVO info = loginDao.queryLoginInfo(loginVO);
		assertNull(info);

		System.out.println("queryLoginFailTest done");
	}

}
