package com.iava.dp.creation.factorymethod;

abstract class ShapeFactory {
	protected abstract Shape factoryMethod(String aName);

	// ��anOperation�ж���Shape��һϵ����Ϊ
	public void anOperation(String aName) {
		Shape s = factoryMethod(aName);
		System.out.println("The current shape is: " + s.name);
		s.draw();
		s.erase();
	}
}