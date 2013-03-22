package com.iava.dp.behavioral.visitor.demo1;


public class Man implements Person{

	public void accept(Visitor visitor) {
        visitor.visit(this);
	}
}