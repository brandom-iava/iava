package com.iava.base.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String args[]) {

		IHelloWorld ihw = (IHelloWorld) Proxy.newProxyInstance(
				HelloWorldImpl.class.getClassLoader(),
				HelloWorldImpl.class.getInterfaces(), new LogInvocationHandler(new HelloWorldImpl()));

		ihw.sayHello("world");
	}
}
