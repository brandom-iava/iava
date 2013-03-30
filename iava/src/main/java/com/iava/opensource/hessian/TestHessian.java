package com.iava.opensource.hessian;

import com.caucho.hessian.client.HessianProxyFactory;

public class TestHessian {

	public static void main(String[] args) throws Exception {  
		  
        HessianProxyFactory proxyFactory = new HessianProxyFactory();;  
  
        MyService service = (MyService) proxyFactory.create(MyService.class,  
  
                "http://localhost:8003/iava/myservice");
  
        System.out.println(service.doSomething("xixixixi"));
  
        System.out.println("ok!");
  
    }  
  
}
