package com.iava.dp.behavioral.visitor.demo1;

import java.util.*;

public class ObjectStructure {
    private List<Person> elements = new ArrayList<Person>();

    public void attach(Person element){
    	elements.add(element);
    }
    
    public void detach(Person element){
    	elements.remove(elements);
    }
    
    //遍历各种具体元素并执行他们的accept方法
    public void display(Visitor visitor){
    	for(Person p:elements){
    		p.accept(visitor);
    	}
    }
}


