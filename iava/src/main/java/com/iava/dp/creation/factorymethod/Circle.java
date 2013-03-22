package com.iava.dp.creation.factorymethod;

//圆形子类
class Circle extends Shape {
	public void draw() {
		System.out.println("It will draw a circle.");
	}

	public void erase() {
		System.out.println("It will erase a circle.");
	}

	// 构造函数
	public Circle(String aName) {
		super(aName);
	}
}