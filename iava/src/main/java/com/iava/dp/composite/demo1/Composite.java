package com.iava.dp.composite.demo1;

import java.util.Enumeration;
import java.util.Vector;

public class Composite implements Component {

	private Vector componentVector = new Vector();
	
/**
 * ı��ҵ�񷽷�
 * */
	public void sampleOperation() {
		Enumeration enumeration = components();
		while (enumeration.hasMoreElements()){
			((Component)(enumeration.nextElement())).sampleOperation();
		}
	}
	/**
	 * �ۼ�������������һ���ӹ�������
	 * */
	public void add(Component component){
		componentVector.add(component);
//		System.out.println("++++++++++"+componentVector.size());
	}
	/**
	 * �ۼ���������ɾ��һ���ӹ�������
	 * */
	public void remove(Component component){
		componentVector.remove(component);
//		System.out.println("----------"+componentVector.size());
	}
	/**
	 * �ۼ������������ؾۼ���Enumeration����
	 * */
	public Enumeration components(){
		System.out.println("**********"+componentVector.size());
		return componentVector.elements();
	}
}
