package com.iava.dp.behavioral.state.demo1;

public class Context {
    // context�ĵ�ǰ״̬
    private State state;

    public Context() {
	this.state = new FirstState();
    }

    public State getSteate() {
	return state;
    }

    public void setState(State state) {
	this.state = state;
    }

    public void execute() {
	this.state.handle(this);
    }
}

