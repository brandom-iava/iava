package com.iava.dp.behavioral.visitor.demo;

public class Fund extends Service {
	//����ҵ��������
	public void accept(Visitor visitor) {
		visitor.process(this);	
	}
}
