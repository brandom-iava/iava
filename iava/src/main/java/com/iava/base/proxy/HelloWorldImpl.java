package com.iava.base.proxy;

public class HelloWorldImpl implements IHelloWorld{

	@Override
	public String sayHello(String name) {
		String result = "Hello, " + name;
		System.out.println(result);
		return null;
	}

}
