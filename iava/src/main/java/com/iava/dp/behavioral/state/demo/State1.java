package com.iava.dp.behavioral.state.demo;

public class State1 implements State{
    public void execute(FindState find,int id) {
        if(id == 1){
            System.out.println("1");
        }else{
            find.setState(new State2());
            find.stateFind(id);
        }
    }
}

