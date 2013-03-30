package com.iava.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CacheManager manager = CacheManager.create("F:\\tydic\\wss\\workspace\\iava\\iava\\src\\main\\resources\\com\\iava\\config\\ehcache.xml");

		// 通过manager可以生成指定名称的Cache对象
		Cache cache =  manager.getCache("sampleCache1");
		Element ele = new Element("key","value");
		cache.put(ele);
		
		System.out.println(cache.get("key"));
	}

}
