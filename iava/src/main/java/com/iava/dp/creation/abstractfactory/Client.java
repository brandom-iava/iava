package com.iava.dp.creation.abstractfactory;

public class Client {

	
	public static void main(String[] args) {
		
     //Ҫһ�������Ƶĳ���
		AbstractFactory af1 = new ConcreteFactory1("������");//��������������
		af1.createProductA();//���������Ƶĳ���
		af1.createProductB();//���������ƵĿ���
	}

}
