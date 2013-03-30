package com.iava;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.iava.opensource.spring.AppUserDao;
import com.iava.spring.BaseSpringTest;

public class AopSpringTest extends BaseSpringTest{
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
