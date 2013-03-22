package com.iava.dp.creation.abstractfactory;

public class Client {

	
	public static void main(String[] args) {
		
     //要一个李宁牌的衬衫
		AbstractFactory af1 = new ConcreteFactory1("李宁牌");//生产所有李宁牌
		af1.createProductA();//生产李宁牌的衬衫
		af1.createProductB();//生产李宁牌的裤子
	}

}
