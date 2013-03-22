package com.iava.dp.behavioral.visitor.demo;

public class Visitor {
	
	public void process(Service service){
		// 默认业务
		System.out.println("处理默认业务");
	}
	
	public void process(Saving service){
		// 存款
		System.out.println("处理存款");
	}
	
	public void process(Draw service){
		// 提款
		System.out.println("处理提款");
	}
	
	public void process(Fund service){
		// 基金
		System.out.println("处理基金");
	}
} 