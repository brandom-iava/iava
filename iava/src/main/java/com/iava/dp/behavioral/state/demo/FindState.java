package com.iava.dp.behavioral.state.demo;

public class FindState {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public FindState(State state) {
        this.state = state;
    }

    public void stateFind(int id) {
        state.execute(this, id);
    }
}

