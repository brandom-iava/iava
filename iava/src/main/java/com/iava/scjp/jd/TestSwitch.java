package com.iava.scjp.jd;

class Super {
	public int i = 0;

	private void method1() {// private is final early binding
		System.out.println("super's method1()");
	}

	public void method2() {
		System.out.println("super's method2()");
		method1();
	}

	public Super getThis() {
		return this;
	}

	public Super() {
		i=7;
	}// must have,though TestSwitch not call()

	public Super(String text) {
		i = 1;
	}
}

public class TestSwitch extends Super {
	private int i = 0;
	public void method1() {
		System.out.println("TestSwitch's method1()");
	}

	public Super getThis() {
		return this;
	}

	public TestSwitch(String text) {
		i = 2;
		method1();// can't call super.method1()
	}

	public static void main(String args[]) {
		Super sub = new TestSwitch("Hello");
		System.out.println("sub's i is: " + sub.i);
		sub.method2();
		System.out.println("getThis is: " + sub.getThis().toString());

	}
}