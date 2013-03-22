package com.iava.dp.behavioral.chain.demo2.inner;

public class NumberHandler extends Handler { 
    public void handleRequest(char c) { 
        if(Character.isDigit(c)) { 
            System.out.println("Number has been handled"); 
        } 
        else {
            getSuccessor().handleRequest(c); 
        }
    } 
}  
