package com.iava.dp.creation.factorymethod;

//定义返回 Square 实例的 SquareFactory
class SquareFactory extends ShapeFactory {
	// 重载factoryMethod方法,返回Square对象
	protected Shape factoryMethod(String aName) {
		return new Square(aName + " (created by SquareFactory)");
	}
}
