package com.iava.dp.behavioral.state.demo4;

public class OffState implements State {
    public void switchFire(FireSwitch sw) {
        sw.setState(new SmallState());
        System.out.println( "small fire" );
    }
}

