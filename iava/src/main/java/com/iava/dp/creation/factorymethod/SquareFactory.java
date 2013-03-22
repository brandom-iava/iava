package com.iava.dp.creation.factorymethod;

//���巵�� Square ʵ���� SquareFactory
class SquareFactory extends ShapeFactory {
	// ����factoryMethod����,����Square����
	protected Shape factoryMethod(String aName) {
		return new Square(aName + " (created by SquareFactory)");
	}
}
