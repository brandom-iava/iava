package com.iava.base;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String args[]){

		SortedMap<String, String> smap = new TreeMap<String,String>();
		smap.put("a", "a");
		smap.put("b", "b");
		smap.put("c", "c");
		smap.put("d", "d");
		
		SortedMap<String, String> tmap = smap.tailMap("b");
		System.out.println(tmap);
		SortedMap<String, String> tmap1 = smap.tailMap("d");
		System.out.println(tmap1);
	}
}
