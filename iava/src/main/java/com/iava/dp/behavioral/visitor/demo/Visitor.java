package com.iava.dp.behavioral.visitor.demo;

public class Visitor {
	
	public void process(Service service){
		// Ĭ��ҵ��
		System.out.println("����Ĭ��ҵ��");
	}
	
	public void process(Saving service){
		// ���
		System.out.println("������");
	}
	
	public void process(Draw service){
		// ���
		System.out.println("�������");
	}
	
	public void process(Fund service){
		// ����
		System.out.println("�������");
	}
} 