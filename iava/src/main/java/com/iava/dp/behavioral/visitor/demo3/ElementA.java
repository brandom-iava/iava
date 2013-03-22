package com.iava.dp.behavioral.visitor.demo3;

public class ElementA implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
                                                                                
    public void operationA() {
        System.out.println("do A's job....such-and-such....");
    }
}

