package com.iava.dp.behavioral.visitor.demo1;

//�ɹ�ʱMan��Woman�Ĳ�ͬ����
public class Success implements Visitor{

	public void visit(Man man) {
		System.out.println("�����˳ɹ�ʱ����������һ��ΰ���Ů��");
	}


	public void visit(Woman woman) {
		System.out.println("��Ů�˳ɹ�ʱ����������һ�����ɹ�������");
	}
}

