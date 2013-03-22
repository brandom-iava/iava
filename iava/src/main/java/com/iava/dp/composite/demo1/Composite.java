package com.iava.dp.composite.demo1;

import java.util.Enumeration;
import java.util.Vector;

public class Composite implements Component {

	private Vector componentVector = new Vector();
	
/**
 * 谋个业务方法
 * */
	public void sampleOperation() {
		Enumeration enumeration = components();
		while (enumeration.hasMoreElements()){
			((Component)(enumeration.nextElement())).sampleOperation();
		}
	}
	/**
	 * 聚集管理方法，增加一个子构建对象
	 * */
	public void add(Component component){
		componentVector.add(component);
//		System.out.println("++++++++++"+componentVector.size());
	}
	/**
	 * 聚集管理方法，删除一个子构建对象
	 * */
	public void remove(Component component){
		componentVector.remove(component);
//		System.out.println("----------"+componentVector.size());
	}
	/**
	 * 聚集管理方法，返回聚集的Enumeration对象
	 * */
	public Enumeration components(){
		System.out.println("**********"+componentVector.size());
		return componentVector.elements();
	}
}
