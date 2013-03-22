package com.iava.dp.behavioral.visitor.demo3;

public class Main {
    public static void main(String[] args) {
        Element[] list = {new ElementA(), new ElementB(), new ElementC()};
                                                                                
        System.out.println("visitorA is coming.......");
        Visitor visitorA = new VisitorA();
        for (int i=0; i < list.length; i++)
            list[i].accept(visitorA);
                                                                                
        System.out.println("\nvisitorB is coming.......");
        Visitor visitorB = new VisitorB();
        for (int i=0; i < list.length; i++)
            list[i].accept(visitorB);
    }
}
