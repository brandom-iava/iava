package com.iava.dp.creation.factorymethod;

//���巵�� circle ʵ���� CircleFactory
class CircleFactory extends ShapeFactory {
	
	// ����factoryMethod����,����Circle����
	protected Shape factoryMethod(String aName) {
		
		return new Circle(aName + " (created by CircleFactory)");
	}
}
