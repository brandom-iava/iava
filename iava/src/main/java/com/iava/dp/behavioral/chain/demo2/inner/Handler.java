package com.iava.dp.behavioral.chain.demo2.inner;

public class Handler { 
    private Handler successor;

    public void setSuccessor(Handler successor) { 
        this.successor = successor; 
    }

    public Handler getSuccessor() { 
        return successor; 
    }

    public void handleRequest(char c) { 
        if(successor != null) 
            successor.handleRequest(c); 
    } 
}  
