package com.iava.scjp.c92to147;

class Base {
	int i = 99;

	public void amethod() {
		System.out.println("Base.amethod ()");
	}
}

public class RType extends Base {
	int i = -1;

	public static void main(String argv[]) {
		Base b = new RType(); // <= Note the type
		System.out.println(b.i);
		b.amethod();
	}

	public void amethod() {
		System.out.println("RType.amethod ()");
	}
}