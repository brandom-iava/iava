package com.iava.opensource.spring;

import org.springframework.stereotype.Service;

import com.iava.cache.Memcached;

@Service(value="appUserDao")
public class AppUserDaoImpl implements AppUserDao{

	
	@Memcached/*(expireTime=60000)*/
	@Override
	public String testMemcache() {
		return "test user";
	}

}
