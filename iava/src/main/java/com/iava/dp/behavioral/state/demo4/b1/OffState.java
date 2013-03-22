package com.iava.dp.behavioral.state.demo4.b1;

public class OffState implements State {
    public void switchClockWise(FireSwitch sw) {
        sw.setState(new SmallState());
        System.out.println("small fire");
    }
                                                                                
    public void switchCountClock(FireSwitch sw) {
        sw.setState(new LargeState());
        System.out.println("large fire");
    }
}
