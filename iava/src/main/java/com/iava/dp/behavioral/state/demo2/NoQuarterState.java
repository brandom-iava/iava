package com.iava.dp.behavioral.state.demo2;
//实现我们的状态类 
// 没有25分钱
public class NoQuarterState implements State {	//先实现State接口
	GumballMachine gumballMachine;
	//通过构造器得到糖果机的引用
	public NoQuarterState(GumballMachine gumballMachine) {
	this.gumballMachine = gumballMachine;
	}
	//还是那几个方法
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		//你马上会看到这里如何工作的
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
	}
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	 }
	public void dispense() {
		System.out.println("You need to pay first");
	} 
	public String toString() {
		return "waiting for quarter";
	}
}