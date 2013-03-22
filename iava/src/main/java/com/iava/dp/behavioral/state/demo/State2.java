package com.iava.dp.behavioral.state.demo;

public class State2 implements State {
    public void execute(FindState find, int id) {
        if(id == 2){
            System.out.println("2");
        }else{
            find.setState(new State3());
            find.stateFind(id);
        }
    }
}

