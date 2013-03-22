package com.iava.dp.behavioral.visitor.demo;

public class Client {
	public static void main(String[] args) {
		Service s1 = new Saving();
		Service s2 = new Draw();
		Service s3 = new Fund();
		
		Visitor visitor = new Visitor();
		
		s1.accept(visitor);
		s2.accept(visitor);
		s3.accept(visitor);
	}
}
