package com.iava.base.operator;

public class OperatorTest {

	public static void main(String args[]){
		//System.out.println(9&5);//9（00001001）的补码&   5（00000101）= 00000001
		
		//System.out.println(~9);
		//System.out.println(max(9,10));
		long t = System.currentTimeMillis();
		for(int i=0 ; i<100000000; i++){
			max(9,10);
		}
		System.out.println(System.currentTimeMillis() - t);
		t = System.currentTimeMillis();
		for(int i=0 ; i<100000000; i++){
			max1(9,10);
		}
		System.out.println(System.currentTimeMillis() - t);
	}
	
	public static int  max(int x, int y){
		int m;
		m = (x-y) >> 31;
		return y & m | x & ~m;
	}
	
	public static int max1(int x, int y){
		return (x >= y) ? x : y;
	}
}
