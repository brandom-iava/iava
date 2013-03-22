package com.iava.dp.behavioral.state.demo4;

public class FireSwitch {
    private State _current;
                                                                                
    public FireSwitch() {
        _current = new OffState();
    }
                                                                                
    public void setState(State s) {
        _current = s;
    }
                                                                                
    public void switchFire() {
        _current.switchFire(this);
    }
}

