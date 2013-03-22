package com.iava.dp.behavioral.state.demo4;

public class SmallState implements State {
    public void switchFire(FireSwitch sw) {
        sw.setState(new MediumState());
        System.out.println( "medium fire" );
    }
}

