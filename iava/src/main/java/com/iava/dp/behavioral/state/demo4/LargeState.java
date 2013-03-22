package com.iava.dp.behavioral.state.demo4;

public class LargeState implements State {
    public void switchFire(FireSwitch sw) {
        sw.setState(new OffState());
        System.out.println( "off fire" );
    }
}

