package com.iava.dp.behavioral.state.demo1;

public class SecondState extends State {

    @Override
    public void handle(Context context) {
	System.out.println("Current State is : "
		+ context.getSteate().toString());
	this.changeState(context);
    }

    @Override
    public void changeState(Context context) {
	context.setState(new FirstState());
    }

    public String toString() {
	return this.getClass().getSimpleName();
    }
}


