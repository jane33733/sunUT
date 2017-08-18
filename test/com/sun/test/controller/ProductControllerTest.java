package com.sun.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ProductControllerTest {

	private MockMvc mockMvc;
	
	@Inject
    private WebApplicationContext wac;

	@Test
	public void testGetByPrice() throws Exception {

	}

	@Test
	public void testSearch() throws Exception {

	}
}
