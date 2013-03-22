package com.iava.dp.behavioral.state.demo4.b1;

public class FireSwitch {
    private State _current;
                                                                                
    public FireSwitch() {
        _current = new OffState();
    }
                                                                                
    public void setState(State s) {
        _current = s;
    }
                                                                                
    public void switchClockWise() {
        _current.switchClockWise(this);
    }
                                                                                
    public void switchCountClock() {
       _current.switchCountClock(this);
    }
}

