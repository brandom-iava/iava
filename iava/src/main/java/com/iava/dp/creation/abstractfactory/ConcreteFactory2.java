package com.iava.dp.creation.abstractfactory;

public class ConcreteFactory2 implements AbstractFactory{

	private String name ;
	
	public ConcreteFactory2(String name)
	{
		super();
		this.name = name;
	}
	
	public AbstractProductA createProductA() {
	     
		return new ConcreteProductA2(name);
	}

	public AbstractProductB createProductB() {
		
		return new ConcreteProductB2(name);
	}

}
