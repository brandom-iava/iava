package com.iava.opensource.spring;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.iava.cache.Memcached;

@Service(value="appUserDao2")
public class AppUserDaoImpl2 implements AppUserDao{

	@Memcached(expireTime=60000)
	@Override
	public String testMemcache() {
		return "test user";
	}
	
	@PostConstruct
	public void postConstruct(){
		System.out.println("AppUserDaoImpl2 has created!");
	}
}
