package com.iava.dp.behavioral.state.demo4;

public class MediumState implements State {
    public void switchFire(FireSwitch sw) {
        sw.setState(new LargeState());
        System.out.println( "large fire" );
    }
}

