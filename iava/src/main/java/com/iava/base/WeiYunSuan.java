package com.iava.base;

public class WeiYunSuan {

	public static void main(String args[]){
		int a = 12345;//...0101
		int b = 12346;//...0110
		int c = 63;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println(Integer.toBinaryString(c));
		System.out.println(a&b);
	}
}
