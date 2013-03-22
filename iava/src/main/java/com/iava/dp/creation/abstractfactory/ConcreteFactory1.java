package com.iava.dp.creation.abstractfactory;

public class ConcreteFactory1 implements AbstractFactory{

	private String name;
	
	public ConcreteFactory1(String name)
	{
		super();
		this.name = name;
	}
	public AbstractProductA createProductA() {
	         return new ConcreteProductA1(name);	
	}

	public AbstractProductB createProductB() {
		return new ConcreteProductB1(name);
	}
	
	

}