package com.iava.dp.creation.factorymethod;

//Բ������
class Circle extends Shape {
	public void draw() {
		System.out.println("It will draw a circle.");
	}

	public void erase() {
		System.out.println("It will erase a circle.");
	}

	// ���캯��
	public Circle(String aName) {
		super(aName);
	}
}