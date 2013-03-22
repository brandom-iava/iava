package com.iava.dp.behavioral.state.demo4.b1;

public class MediumState implements State {
    public void switchClockWise(FireSwitch sw) {
        sw.setState(new LargeState());
        System.out.println("large fire");
    }
                                                                                
    public void switchCountClock(FireSwitch sw) {
        sw.setState(new SmallState());
        System.out.println("small fire");
    }
}

