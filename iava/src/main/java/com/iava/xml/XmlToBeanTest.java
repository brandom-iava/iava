package com.iava.xml;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class XmlToBeanTest {

	public static void main(String args[]){
		ComputerClass cc = new  ComputerClass();
		cc.setClassName("�������ѧ�뼼��");
		cc.setClassAddr("���״�ѧ");
		
		Student st = new Student();
		st.setAddr("����");
		st.setName("���ƽ");
		
		Student st1 = new Student();
		st1.setAddr("�ⶫ");
		st1.setName("������");
		
		List<Student> stList = new ArrayList<Student>();
		stList.add(st1);
		stList.add(st);
		cc.setStudentList(stList);
		
		XStream  sx = new XStream(new DomDriver());
		
		//XStream  sx = new XStream(new Dom4JDriver());
		//XStream  sx = new XStream(new StaxDriver());
		//sx.alias("CC", ComputerClass.class);
		//sx.alias("Student", Student.class);
		sx.autodetectAnnotations(true);
		String xml = sx.toXML(cc);
		System.out.println(xml);
		
		ComputerClass cmc = (ComputerClass)sx.fromXML(xml);

		cmc.getClassName();
	}
}
