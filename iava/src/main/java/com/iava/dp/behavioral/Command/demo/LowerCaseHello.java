package com.iava.dp.behavioral.Command.demo;

public class LowerCaseHello implements ICommand {
    private String name;
    
    public LowerCaseHello(String name) {
        this.name = name;    
    }
    
    public void execute() {
        System.out.println("hello, " + name.toLowerCase());
    }
} 
