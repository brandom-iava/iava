package com.iava;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.iava.opensource.hessian.MyService;
import com.iava.spring.BaseSpringTest;

public class SpringHessianTest extends BaseSpringTest{

	@Autowired
	@Qualifier(value="myServiceHessianProxy")
	private MyService service;
	
	@Test
	public void test(){
		 System.out.println(service.doSomething("hello , spring hessian!"));
	}

	/**
	 * @return the service
	 */
	public MyService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(MyService service) {
		this.service = service;
	}
}
