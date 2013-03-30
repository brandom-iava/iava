package com.iava.opensource.hessian;

public class MyServiceImpl implements MyService{

	@Override
	public String doSomething(String s) {
		 return "HAHAHA: " + s;  
	}

}
