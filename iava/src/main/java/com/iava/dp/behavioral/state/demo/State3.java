package com.iava.dp.behavioral.state.demo;

public class State3 implements State {
    public void execute(FindState find, int id) {
        if(id == 3){
            System.out.println("3");
        }else{
            find.setState(new State3());
            find.stateFind(id);
        }
    }
}
