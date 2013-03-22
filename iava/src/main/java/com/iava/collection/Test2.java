package com.iava.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testBatchAdd();
		//testRandomAccess();
		testLastInsert();
	}

	/**
	 * ������λ����
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void testBatchAdd(){
		List al = new ArrayList();
		//����20������
		for(int i = 0; i<200000; i++){
			al.add(null);
		}
		long t1 = System.currentTimeMillis();
		//���Ѿ����ڵ�20��֮ǰ����2������
		for(int i=0; i<20000; i++){
			al.add(i, null);
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);

		List ll = new LinkedList();
		//����20������
		for(int i = 0; i<200000; i++){
			ll.add(null);
		}
		t1= System.currentTimeMillis();
		////���Ѿ����ڵ�20��֮ǰ����2����
		for(int i=0; i<20000; i++){
			ll.add(i, null);
		}
		t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
	}
	
	/**
	 * �����������
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void testRandomAccess(){
		List al = new ArrayList();
		for(int i=0; i<200000; i++){
			al.add("hello world " + i);
		}
		
		long t1 = System.currentTimeMillis();
		System.out.println(al.get(100000));
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		
		List ll = new LinkedList();
		for(int i=0; i<200000; i++){
			ll.add("hello world " + i);
		}
		
		t1 = System.currentTimeMillis();
		System.out.println(ll.get(100000));
		t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
	}
	
	/**
	 * ����ĩβ����
	 */
	private static void testLastInsert(){
		List al = new ArrayList(200000);
		long t1 = System.currentTimeMillis();
		for(int i=0; i<200000; i++){
			al.add(i,"hello world " + i);
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		
		List ll = new LinkedList();
		t1 = System.currentTimeMillis();
		for(int i=0; i<200000; i++){
			ll.add(i,"hello world " + i);
		}
		t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
	}
}
