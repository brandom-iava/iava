package com.iava.dp.creation.factorymethod;

//方形子类
class Square extends Shape {
	public void draw() {
		System.out.println("It will draw a square.");
	}

	public void erase() {
		System.out.println("It will erase a square.");
	}

	// 构造函数
	public Square(String aName) {
		super(aName);
	}
}
