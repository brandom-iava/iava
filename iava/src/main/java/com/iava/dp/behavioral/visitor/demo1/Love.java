package com.iava.dp.behavioral.visitor.demo1;

//����ʱMan��Woman�Ĳ�ͬ����
public class Love implements Visitor{

	public void visit(Man man) {
		System.out.println("����������ʱ�����²���Ҳװ��");
	}


	public void visit(Woman girl) {
		System.out.println("��Ů������ʱ�����¶�Ҳװ����");
	}
}

