package com.iava.dp.behavioral.state.demo2;

//我们先创建一个State接口,所有的状态都必须实现这个接口
public interface State {
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}

