package com.iava.dp.behavioral.visitor.demo;

public class Service {
	public void accept(Visitor visitor) {
		visitor.process(this);	
	}
} 