package com.iava.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler{

	IHelloWorld hello ;
	
	public LogInvocationHandler(IHelloWorld hello){
		this.hello = hello;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		 /** 
         * 网上关于这里最多问题就是Object proxy放在这里用来做什么呢？这个我也不知道， 
         * 不过至少我们知道它到底是个什么东西，具体做什么用嘛就不得而知了 
         */  
        System.out.println(proxy.getClass().getSimpleName());  
		System.out.println("start say!");
		return method.invoke(hello, args);
	}

}
