package com.iava.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.iava.opensource.spring.AppUserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = { "classpath:com/iava/config/spring-default.xml"})
public class BaseSpringTest {

	@Autowired
	@Qualifier(value="appUserDao2")
	//@Resource(name="appUserDao")
	private AppUserDao appuserDao;
	
	@Test
	public void testMemcacheQuery(){
		appuserDao.testMemcache();
		System.out.println("hellword");
	}
	public AppUserDao getAppuserDao() {
		return appuserDao;
	}
	public void setAppuserDao(AppUserDao appuserDao) {
		this.appuserDao = appuserDao;
	}
	
}
