package com.iava.dp.behavioral.visitor.demo3;

public class VisitorA implements Visitor {
    public void visit(ElementA element) {
        element.operationA();
    }
                                                                                
    public void visit(ElementB element) {
        element.operationB();
    }
                                                                                
    public void visit(ElementC element) {
        element.operationC();
    }
}

