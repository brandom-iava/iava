package com.iava.dp.composite.demo1;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//操作单一方法
		Leaf l= new Leaf();
		l.sampleOperation();

		//构造根枝
		Composite allc = new Composite();
		//构造次枝
		Composite c1 = new Composite();
		allc.add(c1);
		//构造叶子
		c1.add(new Leaf());
		c1.add(new Leaf());
		c1.remove(new Leaf());

		allc.sampleOperation();
	}

}
