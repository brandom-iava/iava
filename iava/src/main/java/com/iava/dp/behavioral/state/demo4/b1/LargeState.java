package com.iava.dp.behavioral.state.demo4.b1;

public class LargeState implements State {
    public void switchClockWise(FireSwitch sw) {
        sw.setState(new OffState());
        System.out.println("off fire");
    }
                                                                                
    public void switchCountClock(FireSwitch sw) {
        sw.setState(new MediumState());
        System.out.println("medium fire");
    }
}

