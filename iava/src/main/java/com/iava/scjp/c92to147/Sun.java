package com.iava.scjp.c92to147;

public class Sun extends Father{

	private int age = 98;
	@Override
	protected void getinfo() {
			getAge();
	}
	
	public static void main(String args[]){
		Father sun = new Sun();
		sun.getinfo();
		float a = 3.4f;
	}
}
