package com.iava.dp.behavioral.visitor.demo2;

import java.util.ArrayList;
import java.util.Date;

public class Client {

    public static void main(String args[]){
        ArrayList list = new ArrayList();
        list.add("a");
        list.add("b");
        Visitor v = new PrintVisitor();
        v.visit("hello");
        v.visit(new Date());
        Visitor v1 = new PrintVisitor2();
        v1.visit("hello");
        v1.visit(list);
    }


}
