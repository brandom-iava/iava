package com.iava.scjp.jd.j1;

public class X {
	public static void main(String[] args) {
		try {
			badMethod();
			System.out.print("A");
		} catch (Exception ex) {
			System.out.print("C");
		} finally {
			System.out.print("B");
		}
		System.out.print("D");
	}

	public static void badMethod() {
		throw new Error();
	}
}
