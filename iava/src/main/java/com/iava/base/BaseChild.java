package com.iava.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseChild extends Base{
	BaseChild(){
		
	}
	 /**
	    * @param args
	    */
	   public static void main(String[] args) {
		BaseChild child = new BaseChild();
		System.out.printf("%s %s",child.d,child.c); 
		List<String> list = new ArrayList<String>();
		list.add("heelow rodl");
		String str = "hello";
		String str1 = new String("hello");
		
		String ar[] = new String[list.size()];
		list.toArray(ar);
	}
}
