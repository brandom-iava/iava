package com.iava.dp.behavioral.state.demo1;

public abstract class State {
    public abstract void handle(Context context);
    public abstract void changeState(Context context);
}

