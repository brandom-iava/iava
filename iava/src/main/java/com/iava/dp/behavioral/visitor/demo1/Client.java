package com.iava.dp.behavioral.visitor.demo1;

public class Client {
    public static void main(String[] args) {
		ObjectStructure o = new ObjectStructure();  //������ObjectStructure
		//ʵ��������Ԫ��
		o.attach(new Man());  
		o.attach(new Woman());
		
		//���ɹ�ʱ��ͬԪ�صĲ�ͬ��ӳ
		Visitor success = new Success();           //�����ڳ����Visitor�ӿ�
		o.display(success);
		
		//������ʱ�Ĳ�ͬ��ӳ
		Visitor amativeness = new Love();          //�����ڳ����Visitor�ӿ�
		o.display(amativeness);
		
	}
}


