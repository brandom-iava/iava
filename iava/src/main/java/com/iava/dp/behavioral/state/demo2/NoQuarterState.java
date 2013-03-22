package com.iava.dp.behavioral.state.demo2;
//ʵ�����ǵ�״̬�� 
// û��25��Ǯ
public class NoQuarterState implements State {	//��ʵ��State�ӿ�
	GumballMachine gumballMachine;
	//ͨ���������õ��ǹ���������
	public NoQuarterState(GumballMachine gumballMachine) {
	this.gumballMachine = gumballMachine;
	}
	//�����Ǽ�������
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		//�����ϻῴ��������ι�����
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