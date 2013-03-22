package com.iava.utils;

public class ObjectUtilTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test="";
     String []a1={"1","2"};
     String []b2={"3","4"};
     if(test!=null&&test.trim().length()>0)
     {
    	 System.out.println(test);
     }
     ObjectUtils.nullSafeEquals(a1, b2);
     System.out.println("\u661F\u671F\u4E00");
     char c = 'жа';
     System.out.println(c);
	}

}
