package com.iava.scjp.jd;

public class Test {
	/**
	 * @param Args
	 */
	public static void main(String Args[]) {
		int i = 1, j = 0;
		switch (i) {
		case 2:
			j += 6;
		case 4:
			j += 1;
		default:
			j += 2;
		case 0:
			j += 4;
		}
		System.out.println("j =" + j);

		String str = "abc";
		String str2 = "abc";
		System.out.println(str == str2);
		System.out.println("abc" == "abc");
		System.out.println(str2.equals(str));
		
		int a = 8;
		System.out.println(a/8);System.out.println(a>>3);
		System.out.println(a<<3);
	}
}