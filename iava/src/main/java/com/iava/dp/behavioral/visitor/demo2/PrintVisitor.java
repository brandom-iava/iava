package com.iava.dp.behavioral.visitor.demo2;

import java.util.Date;

public class PrintVisitor extends Visitor{

    public void visit(Float f){
        System.out.println("float:"+f);
    }
    public void visit(Date date){
        System.out.println("date:"+date);
    }
    public void visit(String str){
        System.out.println("string:"+str);
    }
}

