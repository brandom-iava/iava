package com.iava.dp.creation.factorymethod;

//��������
class Square extends Shape {
	public void draw() {
		System.out.println("It will draw a square.");
	}

	public void erase() {
		System.out.println("It will erase a square.");
	}

	// ���캯��
	public Square(String aName) {
		super(aName);
	}
}
