package com.iava.dp.behavioral.visitor.demo;

public class Fund extends Service {
	//各种业务处理流程
	public void accept(Visitor visitor) {
		visitor.process(this);	
	}
}
