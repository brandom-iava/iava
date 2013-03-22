package com.iava.dp.composite.demo1;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//������һ����
		Leaf l= new Leaf();
		l.sampleOperation();

		//�����֦
		Composite allc = new Composite();
		//�����֦
		Composite c1 = new Composite();
		allc.add(c1);
		//����Ҷ��
		c1.add(new Leaf());
		c1.add(new Leaf());
		c1.remove(new Leaf());

		allc.sampleOperation();
	}

}
