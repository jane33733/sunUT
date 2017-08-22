package com.sun.test.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.SessionFactory;
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
import com.sun.entity.SunAccount;
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
	
	@Autowired
    protected SessionFactory sessionFactory;

	private LoginVO loginVO;

	@Test
	@Rollback(true)
	public void queryLoginInfoTest() {

		this.createUser("test", "321");
		
		
		loginVO = new LoginVO();
		loginVO.setAccount("test");
		loginVO.setPassword("321");
		LoginInfoVO info = loginDao.queryLoginInfo(loginVO);
		assertNotNull(info);
		assertEquals(info.getAccount(), loginVO.getAccount());

		System.out.println("queryLoginInfoTest done");
	}
	
//	@Test
//	@Rollback(true)
//	public void createUserTest() {
//		this.createUser("test","asdf");
//		
//	}
	
	@Test
	@Rollback(true)
	public void queryLoginFailTest() {
		
		this.createUser("test", "321");

		loginVO = new LoginVO();
		loginVO.setAccount("william");
		loginVO.setPassword("123");
		LoginInfoVO info = loginDao.queryLoginInfo(loginVO);
		assertNull(info);

		System.out.println("queryLoginFailTest done");
	}
	
	private void createUser(String name, String password) {
		SunAccount account = new SunAccount();
		account.setAccount(name);
		account.setPassword(password);
		account.setId("02");
		account.setStatus(false);
		account.setUserId("001");
		account.setCreateTime(new Date());
		this.sessionFactory.getCurrentSession().save(account);
	}

}
