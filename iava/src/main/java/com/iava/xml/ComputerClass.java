package com.iava.xml;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("CC")
public class ComputerClass implements java.io.Serializable{

	private String className;
	private String classAddr;

	private List<Student> studentList;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassAddr() {
		return classAddr;
	}

	public void setClassAddr(String classAddr) {
		this.classAddr = classAddr;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
}
