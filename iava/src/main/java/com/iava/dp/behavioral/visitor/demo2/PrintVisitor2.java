package com.iava.dp.behavioral.visitor.demo2;

import java.util.List;

public class PrintVisitor2 extends Visitor{

    public void visit(String str){
        System.out.println("string2:"+str);
    }
    public void visit(List list){
        System.out.println("list2:"+list);
    }
}
