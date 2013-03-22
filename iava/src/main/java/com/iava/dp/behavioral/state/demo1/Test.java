package com.iava.dp.behavioral.state.demo1;

public class Test {

    public Test() {
	Context context = new Context();
	context.execute();
	context.setState(new FirstState());
	context.execute();
	context.execute();
	context.execute();
	context.execute();
    }

    public static void main(String[] args) {
	new Test();
    }

}

