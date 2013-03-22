package com.iava.dp.behavioral.template.demo1;

public abstract class AbstractClass {
    public void templateMethod() {
        // step by step template to solve something
        // implementor should follow those step
        opStep1();
        opStep2();
        opStep3();
    }
 
    public abstract void opStep1();
    public abstract void opStep2();
    public abstract void opStep3();
}


