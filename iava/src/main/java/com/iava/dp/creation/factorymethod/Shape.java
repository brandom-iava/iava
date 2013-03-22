package com.iava.dp.creation.factorymethod;

public abstract class Shape {
	// π¥ª≠shape
	public abstract void draw();

	// ≤¡»• shape
	public abstract void erase();

	public String name;

	public Shape(String aName) {
		name = aName;
	}
	
	protected void sayHello()
	{
		System.out.println("hello java!");
	}
}