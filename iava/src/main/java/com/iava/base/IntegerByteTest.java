package com.iava.base;

import java.math.BigInteger;

public class IntegerByteTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Byte b[] = new Byte[]{0,1,0,1};
		Byte c = 122;
		
		Integer a = 126;;
		System.out.println(Integer.toBinaryString(2));
		String ts = "zc@163.com";
		String ts2 = "zc@l63.com";
		System.out.println(ts.equals(ts2));
		System.out.println(ts == ts2);
		
		
		 String str1 = "zc@163.com";   
		 String str2 = "zc@163.com";   
		 System.out.println(str1.equals(str2)); //true 
		 System.out.println(str1==str2); //true
		 
		String test = "101101101010101100011010101110001101010101001110110001101010";
	
		BigInteger bi = new BigInteger(test, 2);
		byte bib[] = bi.toByteArray();
		System.out.println(new BigInteger(bib));
		System.out.println(bi.bitCount());
		System.out.println(bi.toString());
		System.out.println(bi.toString(2));
		
	}

}
