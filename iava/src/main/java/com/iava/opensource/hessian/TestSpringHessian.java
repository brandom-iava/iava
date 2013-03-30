package com.iava.opensource.hessian;

public class TestSpringHessian {

	private MyService service;
	
	public String test(){
		return service.doSomething("hello , spring hessian!");
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
