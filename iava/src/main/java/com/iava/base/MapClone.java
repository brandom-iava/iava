package com.iava.base;

import java.util.HashMap;
import java.util.Map;

public class MapClone {

	public static void main(String args[]){
		HashMap map =  new HashMap();
		map.put("1", "3");
		map.put("2", "4");
		System.out.println(map);
		
		Map cloneMap = (Map)map.clone();
		System.out.println(cloneMap.get("2"));
		
			/*  long sum = 0L;
			  for(long i = 0; i < Integer.MAX_VALUE; ++i){
			    sum += 1;
			  }
			  System.out.println(sum);*/
			}

	
}
