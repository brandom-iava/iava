package com.iava.opensource.xstream;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {
		    public HierarchicalStreamWriter createWriter(Writer writer) {
		        return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
		    }
		});
		
		Person  p = new Person();
		p.setAddress("test");
		p.setName("hello");
		String tt = xstream.toXML(p);
		
		System.out.println(xstream.toXML(p));
		
		xstream.fromXML(tt);
	}

}
