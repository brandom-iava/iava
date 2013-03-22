package com.iava.dp.behavioral.state.demo;

public class FindTest {
    FindState find;

   
    public void init(){
        find = new FindState(new State1());
    }

   
    public void testFind() throws Exception {
        find.stateFind(3);
    }
}
